package com.mostafa.moviesclone.presentation.Screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.core.screen.Screen
import com.mostafa.moviesclone.data.remote.ApiServicesImpl

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        LaunchedEffect(Unit){
            ApiServicesImpl().getPopularMovies()
        }
    }
}