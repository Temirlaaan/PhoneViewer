package com.example.phoneviewer

import android.app.Application
import com.example.phoneviewer.fragments.main.MainViewModel
import com.example.phoneviewer.network.createApplicationService
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(applicationContext)
            modules(arrayListOf(
                networkModule,
                viewModelModule
            ))
        }
    }

    private val networkModule = module {
        single { createApplicationService("https://www.mechta.kz/api/v1/") }
    }

    private val viewModelModule = module {
        viewModel { MainViewModel(get()) }
    }
}