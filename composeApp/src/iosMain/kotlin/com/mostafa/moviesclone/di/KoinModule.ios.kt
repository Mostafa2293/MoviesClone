package com.mostafa.moviesclone.di

import com.mostafa.moviesclone.data.local.DatabaseDriverFactory
import com.mostafa.moviesclone.data.local.IOSDatabaseDriverFactory
import org.koin.dsl.module

actual val targetModule = module {
    single<DatabaseDriverFactory> { IOSDatabaseDriverFactory() }
}