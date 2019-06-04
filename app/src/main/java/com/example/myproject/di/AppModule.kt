package com.example.myproject.di

import com.example.myproject.repository.PhotoRepository
import com.example.myproject.retrofit.ProexeService
import com.example.myproject.viewmodel.PhotoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single { ProexeService.create() }
}

val repositoryModule = module {
    single { PhotoRepository(get()) }
}

val viewModelModule = module {
    viewModel { PhotoViewModel(get()) }
}