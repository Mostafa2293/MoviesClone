package com.mostafa.moviesclone.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesDto(
    @SerialName("page")
    val page: Int,
    @SerialName("results")
    val results: List<MoviesResultDto>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int
)