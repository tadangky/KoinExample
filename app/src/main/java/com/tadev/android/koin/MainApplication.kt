package com.tadev.android.koin

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    viewModelModule,
                    repositoryModule,
                    apiModule,
                    retrofitModule
                )
            )
        }


    }

}
