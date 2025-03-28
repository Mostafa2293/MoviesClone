package com.mostafa.moviesclone.presentation.Home

import com.mostafa.moviesclone.domain.models.MoviesModel

data class HomeDataState(
    val isLoading: Boolean = true,
    val popularMovies: List<MoviesModel> = emptyList(),
    val topRatedMovies: List<MoviesModel> = emptyList(),
    val upcomingMovies: List<MoviesModel> = emptyList(),
)
