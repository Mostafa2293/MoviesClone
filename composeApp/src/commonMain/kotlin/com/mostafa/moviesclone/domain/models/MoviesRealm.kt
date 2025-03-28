package com.mostafa.moviesclone.domain.models

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

open class MoviesRealm : RealmObject {
    @PrimaryKey
    var id: Int = 0
    var title: String = ""
    var rating: Double = 0.0
    var releaseDate: String = ""
    var posterImage: String = ""
}

fun MoviesModel.toRealm(): MoviesRealm {
    return MoviesRealm().apply {
        id = this@toRealm.id
        title = this@toRealm.title
        rating = this@toRealm.rating
        releaseDate = this@toRealm.releaseDate
        posterImage = this@toRealm.posterImage
    }
}

fun MoviesRealm.toDomain(): MoviesModel {
    return MoviesModel(
        id = this.id,
        title = this.title,
        releaseDate = this.releaseDate,
        rating = this.rating,
        posterImage = this.posterImage
    )
}
