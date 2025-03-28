package com.mostafa.moviesclone.di

import com.mostafa.moviesclone.data.local.AndroidDatabaseDriverFactory
import com.mostafa.moviesclone.data.local.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual val targetModule = module {
    single<DatabaseDriverFactory> { AndroidDatabaseDriverFactory(androidContext()) }
}