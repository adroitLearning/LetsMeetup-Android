package com.adroit.letslinkup.di

import com.adroit.letslinkup.repository.MainRepository
import com.adroit.letslinkup.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

    single { MainRepository(get()) }
    viewModel { MainViewModel(get()) }

}
