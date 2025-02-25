package com.mostafa.moviesclone.domain

import com.mostafa.moviesclone.domain.models.PopularMoviesModel

interface ApiServices {
    suspend fun getPopularMovies(): RequestState<List<PopularMoviesModel>>
}