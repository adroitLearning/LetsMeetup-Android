package com.adroit.letslinkup.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.adroit.letslinkup.R

class SplashActivity : Activity() {
    private val SPLASH_TIME_OUT:Long=3000 // 3 sec
    var prefs: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash_screen)

        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val logedin = sharedPreference.getString("islogged_in","default anme")

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            if (logedin.equals("true")){
                startActivity(Intent(this,MainActivity::class.java))
                finish()
                return@postDelayed
            }
            startActivity(Intent(this,LoginActivity::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)


        /*if (AppPref.isAppIntroShown) {
            if (resources.getBoolean(R.bool.enable_mandatory_authentication)) {
                // Authentication is mandatory
                if (FirebaseAuth.getInstance().currentUser != null) {
                    // Intro shown and user authenticated
                    TestActivity.startActivity(this)
                    finish()
                } else {
                    // Intro shown but user unauthenticated
                    TestActivity.startActivity(this)
                    finish()
                }
            } else {
                // Authentication is optional. Intro shown but user unauthenticated
                LoginActivity.startActivity(this)
                finish()
            }
        } else {
            LoginActivity.startActivity(this)
            finish()
        }*/
    }
}
