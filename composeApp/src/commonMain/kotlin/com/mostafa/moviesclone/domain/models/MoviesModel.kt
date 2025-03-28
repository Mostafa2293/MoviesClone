package com.mostafa.moviesclone.domain.models

data class MoviesModel(
    val id: Int,
    val title: String,
    val posterImage: String,
    val releaseDate: String,
    val rating: Double
)