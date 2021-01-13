package com.adroit.letslinkup.repository

import com.adroit.letslinkup.db.LetsLinkUsDao
import com.adroit.letslinkup.model.Meeting
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository(private val meetingDao: LetsLinkUsDao) {

    suspend fun addMeetingToDb(meeting: Meeting) = withContext(Dispatchers.IO) {
        meetingDao.insertMeeting(meeting)
    }

}