package com.adroit.letslinkup.db

import com.adroit.letslinkup.model.Meeting
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Meeting::class], version = 1, exportSchema = false)
abstract class LetsLinkUsDB : RoomDatabase() {

    abstract fun meetingDao(): LetsLinkUsDao

}