package com.adroit.letslinkup.di

import com.adroit.letslinkup.repository.MeetingHistoryRepository
import com.adroit.letslinkup.viewmodel.MeetingHistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val meetingHistoryModule = module {

    single { MeetingHistoryRepository(get()) }
    viewModel { MeetingHistoryViewModel(get()) }

}
