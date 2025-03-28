package com.mostafa.moviesclone.util

object Constants {

    object Api {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API_KEY = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyZWFiZTJkNmZmMDQwOWQwMWM3OTI2MGQ2MmVmM2FmNyIsIm5iZiI6MTU2NjkyNDkzNC4wMTcsInN1YiI6IjVkNjU2MDg2YmNmOGM5MDAxNTc3MGRmYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.3vQw-Nkr1lsANB5QBQd1CMHPCVMAjhHXxdQ1KJoESHg"
        const val REQUEST_TIMEOUT = 15000L
        const val AUTHORIZATION = "Authorization"
        const val POPULAR_MOVIES_URL = "movie/popular"
        const val TOP_RATED_URL = "movie/top_rated"
        const val UPCOMING_URL = "movie/upcoming"
        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/original"
    }

    object Database {
        const val DB_NAME = "movies_database"
        const val DB_VERSION = 1
    }

    object UI {
        const val DEFAULT_ANIMATION_DURATION = 3000L
    }
}