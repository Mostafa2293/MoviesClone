package com.mostafa.moviesclone.data.dto


import com.mostafa.moviesclone.domain.models.MoviesModel
import com.mostafa.moviesclone.domain.models.MoviesRealm
import com.mostafa.moviesclone.util.attachImageUrl
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesResultDto(
    @SerialName("adult")
    val adult: Boolean?,
    @SerialName("backdrop_path")
    val backdropPath: String?,
    @SerialName("genre_ids")
    val genreIds: List<Int>?,
    @SerialName("id")
    val id: Int?,
    @SerialName("original_language")
    val originalLanguage: String?,
    @SerialName("original_title")
    val originalTitle: String?,
    @SerialName("overview")
    val overview: String?,
    @SerialName("popularity")
    val popularity: Double?,
    @SerialName("poster_path")
    val posterPath: String?,
    @SerialName("release_date")
    val releaseDate: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("video")
    val video: Boolean?,
    @SerialName("vote_average")
    val voteAverage: Double?,
    @SerialName("vote_count")
    val voteCount: Int?
){
    fun toDomain(): MoviesModel {
        return MoviesModel(
            id = id ?: 0,
            posterImage = attachImageUrl(posterPath ?: ""),
            releaseDate = releaseDate ?: "",
            title = title ?: "",
            rating = voteAverage ?: 0.0,
        )
    }
}