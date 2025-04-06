package com.mostafa.moviesclone.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TvDto(
    @SerialName("page")
    val page: Int,
    @SerialName("results")
    val results: List<TvResultDto>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int
)