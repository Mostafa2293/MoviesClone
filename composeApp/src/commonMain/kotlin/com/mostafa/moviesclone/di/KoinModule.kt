package com.mostafa.moviesclone.di

import com.mostafa.moviesclone.data.local.LocalDatabase
import com.mostafa.moviesclone.data.repository.HomeRepoImpl
import com.mostafa.moviesclone.domain.repository.HomeRepo
import com.mostafa.moviesclone.domain.usecases.GetOnTheAirTvUseCase
import com.mostafa.moviesclone.domain.usecases.GetPopularMoviesUseCase
import com.mostafa.moviesclone.domain.usecases.GetPopularTvUseCase
import com.mostafa.moviesclone.domain.usecases.GetTopRatedMoviesUseCase
import com.mostafa.moviesclone.domain.usecases.GetTopRatedTv
import com.mostafa.moviesclone.domain.usecases.GetUpcomingMoviesUseCase
import com.mostafa.moviesclone.presentation.Home.HomeViewModel
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

expect val targetModule: Module

val sharedModule = module {
    single<LocalDatabase> { LocalDatabase(get()) }
    single<HomeRepo> { HomeRepoImpl(get()) }
    factory { GetPopularMoviesUseCase(get()) }
    factory { GetTopRatedMoviesUseCase(get()) }
    factory { GetUpcomingMoviesUseCase(get()) }
    factory { GetOnTheAirTvUseCase(get()) }
    factory { GetPopularTvUseCase(get()) }
    factory { GetTopRatedTv(get()) }
    factory {
        HomeViewModel(
            popularMoviesUseCase = get(),
            topRatedMoviesUseCase = get(),
            upcomingMoviesUseCase = get(),
            onTheAirTvUseCase = get(),
            popularTvUseCase = get(),
            topRatedTvUseCase = get()
        )
    }
}


fun initializeKoin(config: (KoinApplication.() -> Unit)? = null) {
    startKoin {
        config?.invoke(this)
        modules(targetModule, sharedModule)
    }
}