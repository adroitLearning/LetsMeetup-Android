package com.adroit.letslinkup.di

import com.adroit.letslinkup.db.LetsLinkUsDB
import android.app.Application
import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {

    single { provideRoomDatabase(androidApplication()) }
    single { provideMeetingDao(get()) }
}

private fun provideRoomDatabase(androidApplication: Application) =
    Room.databaseBuilder(androidApplication, LetsLinkUsDB::class.java, "adroit-db").build()

private fun provideMeetingDao(meetlyDB: LetsLinkUsDB) =
    meetlyDB.meetingDao()