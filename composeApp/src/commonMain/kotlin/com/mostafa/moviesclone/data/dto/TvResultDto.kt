package com.mostafa.moviesclone.data.dto


import com.mostafa.moviesclone.domain.models.MoviesModel
import com.mostafa.moviesclone.util.attachImageUrl
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TvResultDto(
    @SerialName("adult")
    val adult: Boolean?,
    @SerialName("backdrop_path")
    val backdropPath: String?,
    @SerialName("first_air_date")
    val firstAirDate: String?,
    @SerialName("genre_ids")
    val genreIds: List<Int>?,
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String?,
    @SerialName("origin_country")
    val originCountry: List<String>?,
    @SerialName("original_language")
    val originalLanguage: String?,
    @SerialName("original_name")
    val originalName: String?,
    @SerialName("overview")
    val overview: String?,
    @SerialName("popularity")
    val popularity: Double?,
    @SerialName("poster_path")
    val posterPath: String?,
    @SerialName("vote_average")
    val voteAverage: Double?,
    @SerialName("vote_count")
    val voteCount: Int?
){
    fun toDomain(): MoviesModel {
        return MoviesModel(
            id = id ?: 0,
            posterImage = attachImageUrl(posterPath ?: ""),
            releaseDate = firstAirDate ?: "",
            title = name ?: "",
            rating = voteAverage ?: 0.0,
        )
    }
}