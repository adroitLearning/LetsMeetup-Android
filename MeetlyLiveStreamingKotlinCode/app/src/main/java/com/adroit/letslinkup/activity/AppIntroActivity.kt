package com.adroit.letslinkup.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.adroit.letslinkup.R
import com.github.appintro.AppIntro2

class AppIntroActivity : AppIntro2() {

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, AppIntroActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

      /*  addIntroFragments()
        setTransformer(AppIntroPageTransformerType.Parallax())*/
    }

   /* override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)

        AppPref.isAppIntroShown = true
        AuthenticationActivity.startActivity(this)
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)

        AppPref.isAppIntroShown = true
        AuthenticationActivity.startActivity(this)
        finish()
    }

    private fun addIntroFragments() {
        addSlide(AppIntroFragment.newInstance(
            getString(R.string.app_intro_meeting_title),
            getString(R.string.app_intro_meeting_desc),
            imageDrawable = R.drawable.ic_meeting_app_intro,
            backgroundDrawable = R.drawable.bg_app_intro
        ))

        addSlide(AppIntroFragment.newInstance(
            getString(R.string.app_intro_chat_title),
            getString(R.string.app_intro_chat_desc),
            imageDrawable = R.drawable.ic_chat,
            backgroundDrawable = R.drawable.bg_app_intro
        ))

        addSlide(AppIntroFragment.newInstance(
            getString(R.string.app_intro_meeting_history_title),
            getString(R.string.app_intro_meeting_history_desc),
            imageDrawable = R.drawable.ic_meeting_history,
            backgroundDrawable = R.drawable.bg_app_intro
        ))
        }
        */
    }
