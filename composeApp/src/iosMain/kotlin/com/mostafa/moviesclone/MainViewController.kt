package com.mostafa.moviesclone

import androidx.compose.ui.window.ComposeUIViewController
import com.mostafa.moviesclone.di.initializeKoin

fun MainViewController() = ComposeUIViewController (
    configure = {
        initializeKoin()
    }
) { App() }