package com.tallertechinterview.presentation

import android.app.Application
import com.tallertechinterview.presentation.di.appModule
import org.koin.core.context.startKoin

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
//        startKoin {
//            appModule
//        }
    }
}