package com.mostafa.moviesclone.data.repository

import com.mostafa.moviesclone.data.NetworkService
import com.mostafa.moviesclone.data.dto.MoviesDto
import com.mostafa.moviesclone.data.local.LocalDatabase
import com.mostafa.moviesclone.domain.RequestState
import com.mostafa.moviesclone.domain.models.MoviesModel
import com.mostafa.moviesclone.domain.repository.HomeRepo
import com.mostafa.moviesclone.util.Constants.Api.POPULAR_MOVIES_URL
import com.mostafa.moviesclone.util.Constants.Api.TOP_RATED_URL
import com.mostafa.moviesclone.util.Constants.Api.UPCOMING_URL
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepoImpl (private val localDatabase: LocalDatabase) : HomeRepo {
    override suspend fun getPopularMovies(): Flow<RequestState<List<MoviesModel>>> = flow {
        try {
            println("POPULAR MOVIES: process started")
            val cachedMovies = localDatabase.getAllMovies()
            println("POPULAR MOVIES: cachedMovies: $cachedMovies")
            if (cachedMovies.isNotEmpty()) {
                println("POPULAR MOVIES: inside if")
                emit(RequestState.Success(cachedMovies))
            }else {
                println("POPULAR MOVIES: inside else")
                val popularMoviesDto: MoviesDto = NetworkService.get(POPULAR_MOVIES_URL)
                val popularMoviesModel = popularMoviesDto.results.map { it.toDomain() }
                localDatabase.insertMovies(popularMoviesModel)
                emit(RequestState.Success(popularMoviesModel))
            }

        } catch (e: Exception) {
            emit(RequestState.Error("Error: ${e.message}"))
        }
    }

    override suspend fun getTopRatedMovies(): Flow<RequestState<List<MoviesModel>>> = flow {
        try {
            val topRatedMoviesDto: MoviesDto = NetworkService.get(TOP_RATED_URL)
            val topRatedMoviesModel = topRatedMoviesDto.results.map { it.toDomain() }
            emit(RequestState.Success(topRatedMoviesModel))
        } catch (e: Exception) {
            emit(RequestState.Error("Error: ${e.message}"))
        }
    }

    override suspend fun getUpcomingMovies(): Flow<RequestState<List<MoviesModel>>> = flow {
        try {
            val upcomingMoviesDto: MoviesDto = NetworkService.get(UPCOMING_URL)
            val upcomingMoviesModel = upcomingMoviesDto.results.map { it.toDomain() }
            emit(RequestState.Success(upcomingMoviesModel))
        } catch (e: Exception) {
            emit(RequestState.Error("Error: ${e.message}"))
        }
    }

}