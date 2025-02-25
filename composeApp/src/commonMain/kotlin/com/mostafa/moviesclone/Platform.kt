package com.mostafa.moviesclone

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform