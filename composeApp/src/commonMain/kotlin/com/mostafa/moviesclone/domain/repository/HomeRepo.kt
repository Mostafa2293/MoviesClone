package com.mostafa.moviesclone.domain.repository

import com.mostafa.moviesclone.domain.RequestState
import com.mostafa.moviesclone.domain.models.MoviesModel
import kotlinx.coroutines.flow.Flow

interface HomeRepo {
    suspend fun getPopularMovies(): Flow<RequestState<List<MoviesModel>>>
    suspend fun getTopRatedMovies(): Flow<RequestState<List<MoviesModel>>>
    suspend fun getUpcomingMovies(): Flow<RequestState<List<MoviesModel>>>
}