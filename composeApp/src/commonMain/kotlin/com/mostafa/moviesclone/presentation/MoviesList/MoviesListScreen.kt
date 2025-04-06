package com.mostafa.moviesclone.presentation.MoviesList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen

class MoviesListScreen : Screen {
    @Composable
    override fun Content() {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "Movies List Screen")
        }
    }
}