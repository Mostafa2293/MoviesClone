package com.mostafa.moviesclone.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import com.mostafa.moviesclone.util.Constants.Api.IMAGE_BASE_URL

fun attachImageUrl(imagePath: String): String {
    return IMAGE_BASE_URL + imagePath
}

inline fun Modifier.noRippleClickable(
    crossinline onClick: () -> Unit
): Modifier = composed { this.then(
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
) }