package com.mostafa.moviesclone

import android.app.Application
import com.mostafa.moviesclone.di.initializeKoin
import org.koin.android.ext.koin.androidContext
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeKoin(
            config = { androidContext(this@MyApplication) },
        )
    }
}