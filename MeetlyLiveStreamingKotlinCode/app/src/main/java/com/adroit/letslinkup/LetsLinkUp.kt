package com.adroit.letslinkup

import com.adroit.letslinkup.di.appModule
import com.adroit.letslinkup.di.mainModule
import com.adroit.letslinkup.di.meetingHistoryModule
import com.adroit.letslinkup.sharedpref.AppPref
import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.chibatching.kotpref.Kotpref
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class LetsLinkUp : Application() {

    companion object {
        var isAdEnabled = false
    }

    override fun onCreate() {
        super.onCreate()
      //  isAdEnabled = resources.getBoolean(R.bool.enable_ads)

        initializeKotPref()
        setThemeMode()
        initializeKoin()

        //if (isAdEnabled) initializeAdmob()
    }

    private fun initializeKotPref() {
        Kotpref.init(this)
    }

    private fun setThemeMode() {
        if (AppPref.isLightThemeEnabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }

    private fun initializeKoin() {
        startKoin {
            androidLogger()
            androidContext(this@LetsLinkUp)
            modules(
                listOf(
                    appModule,
                    mainModule,
                    meetingHistoryModule
                )
            )
        }
    }

}