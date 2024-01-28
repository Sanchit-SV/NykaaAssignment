package com.example.nykaaassignment

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ApplicationModule : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidContext(this@ApplicationModule)
            modules(
                remoteDataModule, viewModelModule
            )
        }
    }
}