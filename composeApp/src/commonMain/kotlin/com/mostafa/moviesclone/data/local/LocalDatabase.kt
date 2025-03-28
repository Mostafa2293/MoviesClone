package com.mostafa.moviesclone.data.local

import com.mostafa.moviesclone.MoviezDatabaseQueries
import com.mostafa.moviesclone.domain.models.MoviesModel

class LocalDatabase(databaseDriverFactory: DatabaseDriverFactory) {
    private val queries = MoviezDatabaseQueries(databaseDriverFactory.createDriver())

    fun insertMovies(movies: List<MoviesModel>) {
        println("LocalDatabase: inserting into database...")
        queries.transaction {
            queries.deleteAll()
            movies.forEach { movie ->
                queries.insertMovie(
                    id = movie.id.toLong(),
                    posterImage = movie.posterImage,
                    releaseDate = movie.releaseDate,
                    title = movie.title,
                    rating = movie.rating
                )
            }
        }
    }

    fun getAllMovies(): List<MoviesModel> {
        println("LocalDatabase: Reading from database...")
        return queries.selectAll().executeAsList().map {
            MoviesModel(
                id = it.id.toInt(),
                posterImage = it.posterImage ?: "",
                releaseDate = it.releaseDate ?: "",
                title = it.title ?: "",
                rating = it.rating ?: 0.0
            )
        }
    }

    fun deleteAllMovies() {
        println("LocalDatabase: Deleting all movies from database...")
        queries.deleteAll()
    }

}