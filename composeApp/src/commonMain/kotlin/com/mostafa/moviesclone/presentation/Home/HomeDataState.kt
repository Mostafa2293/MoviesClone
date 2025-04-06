package com.mostafa.moviesclone.presentation.Home

import com.mostafa.moviesclone.domain.models.MoviesModel

data class HomeDataState(
    val isMoviesLoading: Boolean = true,
    val isTvLoading: Boolean = true,
    val popularMovies: List<MoviesModel> = emptyList(),
    val topRatedMovies: List<MoviesModel> = emptyList(),
    val upcomingMovies: List<MoviesModel> = emptyList(),
    val popularTv: List<MoviesModel> = emptyList(),
    val topRatedTv: List<MoviesModel> = emptyList(),
    val onTheAirTv: List<MoviesModel> = emptyList(),
)
