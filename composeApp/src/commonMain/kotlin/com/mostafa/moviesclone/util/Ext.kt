package com.mostafa.moviesclone.util

import com.mostafa.moviesclone.util.Constants.Api.IMAGE_BASE_URL

fun attachImageUrl(imagePath: String): String {
    return IMAGE_BASE_URL + imagePath
}