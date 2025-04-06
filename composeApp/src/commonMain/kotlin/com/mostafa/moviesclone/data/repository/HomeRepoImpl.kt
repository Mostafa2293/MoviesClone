package com.mostafa.moviesclone.data.repository

import com.mostafa.moviesclone.data.NetworkService
import com.mostafa.moviesclone.data.dto.MoviesDto
import com.mostafa.moviesclone.data.dto.TvDto
import com.mostafa.moviesclone.data.local.LocalDatabase
import com.mostafa.moviesclone.domain.RequestState
import com.mostafa.moviesclone.domain.models.MoviesModel
import com.mostafa.moviesclone.domain.repository.HomeRepo
import com.mostafa.moviesclone.util.Constants.Api.TV_ON_THE_AIR_URL
import com.mostafa.moviesclone.util.Constants.Api.MOVIE_POPULAR_URL
import com.mostafa.moviesclone.util.Constants.Api.MOVIE_TOP_RATED_URL
import com.mostafa.moviesclone.util.Constants.Api.MOVIE_UPCOMING_URL
import com.mostafa.moviesclone.util.Constants.Api.TV_POPULAR_URL
import com.mostafa.moviesclone.util.Constants.Api.TV_TOP_RATED_URL
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepoImpl(private val localDatabase: LocalDatabase) : HomeRepo {
    override suspend fun getPopularMovies(): Flow<RequestState<List<MoviesModel>>> = flow {
        try {
            println("POPULAR MOVIES: process started")
            val cachedMovies = localDatabase.getAllMovies()
            println("POPULAR MOVIES: cachedMovies: $cachedMovies")
            if (cachedMovies.isNotEmpty()) {
                println("POPULAR MOVIES: inside if")
                emit(RequestState.Success(cachedMovies))
            } else {
                println("POPULAR MOVIES: inside else")
                val popularMoviesDto: MoviesDto = NetworkService.get(MOVIE_POPULAR_URL)
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
            val topRatedMoviesDto: MoviesDto = NetworkService.get(MOVIE_TOP_RATED_URL)
            val topRatedMoviesModel = topRatedMoviesDto.results.map { it.toDomain() }
            emit(RequestState.Success(topRatedMoviesModel))
        } catch (e: Exception) {
            emit(RequestState.Error("Error: ${e.message}"))
        }
    }

    override suspend fun getUpcomingMovies(): Flow<RequestState<List<MoviesModel>>> = flow {
        try {
            val upcomingMoviesDto: MoviesDto = NetworkService.get(MOVIE_UPCOMING_URL)
            val upcomingMoviesModel = upcomingMoviesDto.results.map { it.toDomain() }
            emit(RequestState.Success(upcomingMoviesModel))
        } catch (e: Exception) {
            emit(RequestState.Error("Error: ${e.message}"))
        }
    }

    override suspend fun getOnTheAirTvs(): Flow<RequestState<List<MoviesModel>>> = flow {
        try {
            val onTheAirTvsDto: TvDto = NetworkService.get(TV_ON_THE_AIR_URL)
            val onTheAirTvsModel = onTheAirTvsDto.results.map { it.toDomain() }
            emit(RequestState.Success(onTheAirTvsModel))
        } catch (e: Exception) {
            emit(RequestState.Error("Error: ${e.message}"))
        }
    }

    override suspend fun getPopularTvs(): Flow<RequestState<List<MoviesModel>>> = flow {
        try {
            val onTheAirTvsDto: TvDto = NetworkService.get(TV_POPULAR_URL)
            val onTheAirTvsModel = onTheAirTvsDto.results.map { it.toDomain() }
            emit(RequestState.Success(onTheAirTvsModel))
        } catch (e: Exception) {
            emit(RequestState.Error("Error: ${e.message}"))
        }
    }

    override suspend fun getTopRatedTvs(): Flow<RequestState<List<MoviesModel>>> = flow {
        try {
            val onTheAirTvsDto: TvDto = NetworkService.get(TV_TOP_RATED_URL)
            val onTheAirTvsModel = onTheAirTvsDto.results.map { it.toDomain() }
            emit(RequestState.Success(onTheAirTvsModel))
        } catch (e: Exception) {
            emit(RequestState.Error("Error: ${e.message}"))
        }
    }

}