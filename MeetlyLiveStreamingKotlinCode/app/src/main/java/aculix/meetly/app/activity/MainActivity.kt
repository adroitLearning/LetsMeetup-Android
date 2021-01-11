package aculix.meetly.app.activity

import aculix.core.extensions.*
import aculix.meetly.app.Meetly
import aculix.meetly.app.R
import aculix.meetly.app.databinding.ActivityMainBinding
import aculix.meetly.app.model.Meeting
import aculix.meetly.app.sharedpref.AppPref
import aculix.meetly.app.utils.MeetingUtils
import aculix.meetly.app.viewmodel.MainViewModel
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.widget.doOnTextChanged
import androidx.drawerlayout.widget.DrawerLayout
import coil.api.load
import com.afollestad.materialdialogs.LayoutMode
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.bottomsheets.BottomSheet
import com.afollestad.materialdialogs.customview.customView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.dynamiclinks.ktx.androidParameters
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.dynamiclinks.ktx.navigationInfoParameters
import com.google.firebase.dynamiclinks.ktx.shortLinkAsync
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.dialog_profile.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    private val viewModel by viewModel<MainViewModel>() // Lazy inject ViewModel
    private lateinit var binding: ActivityMainBinding

    private val minMeetingCodeLength = 10
    private var currentUser: FirebaseUser? = null
  /*  private lateinit var createMeetingInterstitialAd: InterstitialAd
    private lateinit var joinMeetingInterstitialAd: InterstitialAd*/
    var navigationView: NavigationView? = null
    var drawerLayout: DrawerLayout? = null
    private var doubleBackToExitPressedOnce = false
    var prefs: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)
        val logedin = sharedPreference.getString("islogged_in","default anme")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currentUser = FirebaseAuth.getInstance().currentUser
        setProfileIcon()
        handleDynamicLink()
        //onMeetingToggleChange()
        onCreateMeetingCodeChange()
        onCopyMeetingCodeFromClipboardClick()
        onShareMeetingCodeClick()
        onJoinMeetingClick()
        onCreateMeetingClick()
        onMeetingHistoryClick()
        onProfileClick()
    }

    override fun onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            val a = Intent(Intent.ACTION_MAIN)
            a.addCategory(Intent.CATEGORY_HOME)
            a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(a)
            finish()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)

    }

    private fun setProfileIcon() {
        currentUser?.let {
            if (it.photoUrl != null) {
                binding.ivProfile.load(currentUser?.photoUrl) {
                    placeholder(R.drawable.ic_profile)
                }
            }
        }
    }

    private fun handleDynamicLink() {
        Firebase.dynamicLinks
                .getDynamicLink(intent)
                .addOnSuccessListener { pendingDynamicLinkData ->
                    val deepLink: Uri?
                    if (pendingDynamicLinkData != null) {
                        deepLink = pendingDynamicLinkData.link
                        deepLink?.getQueryParameter("meetingCode")?.let { joinMeeting(it) }
                    }
                }
                .addOnFailureListener { _ ->
                    toast(getString(R.string.main_error_fetch_dynamic_link))
                }
    }

    fun onJoinMeetingClick(view: View) {
        binding.groupCreateMeeting.makeGone()
        binding.groupJoinMeeting.makeVisible()
    }

    fun onCreateMeetingClick(view: View) {
        binding.groupJoinMeeting.makeGone()
        binding.groupCreateMeeting.makeVisible()
        val meetingCode = generateMeetingCode()
        binding.etCodeCreateMeeting.setText(meetingCode)
    }

    private fun onCreateMeetingCodeChange() {
        binding.tilCodeCreateMeeting.etCodeCreateMeeting.doOnTextChanged { text, _, _, _ ->
            if (text.toString().trim()
                            .replace(" ", "").length >= minMeetingCodeLength
            ) binding.tilCodeCreateMeeting.error = null
        }
    }

    private fun generateMeetingCode(): String {
        val allowedChars = ('a'..'z') + ('0'..'9')
        return (1..10)
                .map { allowedChars.random() }
                .joinToString("")
    }

    private fun onCopyMeetingCodeFromClipboardClick() {
        binding.tilCodeJoinMeeting.setEndIconOnClickListener {
            val clipboardText = getTextFromClipboard()
            if (clipboardText != null) {
                binding.etCodeJoinMeeting.setText(clipboardText)
                toast(getString(R.string.main_meeting_code_copied))
            } else {
                toast(getString(R.string.main_empty_clipboard))
            }
        }
    }

    /**
     * Called when the share icon is clicked in the EditText of the CREATE MEETING toggle
     */
    private fun onShareMeetingCodeClick() {
        binding.tilCodeCreateMeeting.setEndIconOnClickListener {
            if (isMeetingCodeValid(getCreateMeetingCode())) {
                binding.tilCodeCreateMeeting.error = null
                toast(getString(R.string.main_creating_dynamic_link))

                Firebase.dynamicLinks.shortLinkAsync {
                    link = Uri.parse(getString(R.string.app_deep_link_url, getCreateMeetingCode()))
                    domainUriPrefix = getString(R.string.app_dynamic_link_url_prefix)
                    androidParameters {}
                    navigationInfoParameters {
                        forcedRedirectEnabled = true // Directly open the link in the app
                    }
                }.addOnSuccessListener { result ->
                    val shortDynamicLink = result.shortLink.toString()
                    startShareTextIntent(
                        getString(R.string.main_share_meeting_code_title),
                        getString(R.string.main_share_meeting_code_desc, shortDynamicLink)
                    )
                }.addOnFailureListener{ Exception ->
                    val data = Exception.printStackTrace()

                    //Log.e("TAG", "Error requesting connection", data);
                    toast(getString(R.string.main_error_create_dynamic_link))
                }
            } else {
                binding.tilCodeCreateMeeting.error =
                        getString(R.string.main_error_meeting_code_length, minMeetingCodeLength)
            }
        }
    }

    /**
     * Called when the JOIN button is clicked of the JOIN MEETING toggle
     */
    private fun onJoinMeetingClick() {
        binding.btnJoinMeeting.setOnClickListener {
            if (isMeetingCodeValid(getJoinMeetingCode())) {
                if (Meetly.isAdEnabled) {
                    /* if (joinMeetingInterstitialAd.isLoaded) joinMeetingInterstitialAd.show()
                     else*/
                    joinMeeting(
                        getJoinMeetingCode()
                    )
                } else {
                    joinMeeting(getJoinMeetingCode())
                }
            }
        }
    }

    private fun joinMeeting(meetingCode: String) {
        MeetingUtils.startMeeting(
            this,
            meetingCode,
            R.string.all_joining_meeting
        ) // Start Meeting

        viewModel.addMeetingToDb(
            Meeting(
                meetingCode,
                System.currentTimeMillis()
            )
        ) // Add meeting to db
    }

    /**
     * Returns the meeting code for joining the meeting
     */
    private fun getJoinMeetingCode() =
            etCodeJoinMeeting.text.toString().trim().replace(" ", "")

    /**
     * Called when the CREATE button is clicked of the CREATE MEETING toggle
     */
    private fun onCreateMeetingClick() {
        binding.btnCreateMeeting.setOnClickListener {
            if (isMeetingCodeValid(getCreateMeetingCode())) {
                createMeeting(getCreateMeetingCode())
              /*  if (Meetly.isAdEnabled) {
                    if (createMeetingInterstitialAd.isLoaded) createMeetingInterstitialAd.show() else
                        createMeeting(
                            getCreateMeetingCode()
                    )
                } else {
                    createMeeting(getCreateMeetingCode())
                }*/
            }
        }
    }

    private fun createMeeting(meetingCode: String) {
        MeetingUtils.startMeeting(
            this,
            meetingCode,
            R.string.all_creating_meeting
        ) // Start Meeting

        viewModel.addMeetingToDb(
            Meeting(
                meetingCode,
                System.currentTimeMillis()
            )
        ) // Add meeting to db
    }

    private fun getCreateMeetingCode() =
            binding.etCodeCreateMeeting.text.toString().trim().replace(" ", "")

    private fun isMeetingCodeValid(meetingCode: String): Boolean {
        return if (meetingCode.length >= minMeetingCodeLength) {
            true
        } else {
            Snackbar.make(
                binding.constrainLayout,
                getString(R.string.main_error_meeting_code_length, minMeetingCodeLength),
                Snackbar.LENGTH_SHORT
            ).show()
            false
        }
    }

    private fun onMeetingHistoryClick() {
        binding.ivMeetingHistory.setOnClickListener {
            MeetingHistoryActivity.startActivity(this)
        }
    }

    @SuppressLint("StringFormatInvalid")
    private fun onProfileClick() {
        binding.ivProfile.setOnClickListener {
            val profileDialog = MaterialDialog(this, BottomSheet(LayoutMode.WRAP_CONTENT)).show {
                customView(R.layout.dialog_profile)
            }


            profileDialog.apply {
                // Profile onClick
                tvProfile.setOnClickListener {
                    /*  startEmailIntent(
                              getString(R.string.app_feedback_contact_email),
                              getString(R.string.profile_feedback_email_subject)
                      )*/
                    val intent = Intent(context, ProfileActivity::class.java)
                    context.startActivity(intent)
                }
                // Send feedback onClick
                tvSendFeedback.setOnClickListener {
                    startEmailIntent(
                        getString(R.string.app_feedback_contact_email),
                        getString(R.string.profile_feedback_email_subject)
                    )
                }

                // Rate app onClick
                tvRateApp.setOnClickListener {
                    openAppInGooglePlay(applicationContext.packageName, R.color.colorSurface)
                }

                // Share app onClick
                tvSettings.setOnClickListener {
                    startShareTextIntent(
                        getString(R.string.profile_share_app_title),
                        getString(
                            R.string.profile_share_app_text,
                            applicationContext.packageName
                        )
                    )
                }

                // FAQs onClick
                tvPushNotification.setOnClickListener {
                    //  FaqsActivity.startActivity(this@MainActivity)
                }
            }
        }
    }

    fun onScheduleMeetingClick(view: View) {}
}

private fun setThemeMode(themeMode: Int) {
    AppCompatDelegate.setDefaultNightMode(themeMode)
    AppPref.isLightThemeEnabled = themeMode == AppCompatDelegate.MODE_NIGHT_NO

}
