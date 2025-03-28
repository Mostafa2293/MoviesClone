package com.mostafa.moviesclone.presentation.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import com.example.compose.surfaceLight
import com.mostafa.moviesclone.presentation.components.HomeMoviesSection
import com.mostafa.moviesclone.presentation.components.HomeUpcomingMoviesSection
import com.mostafa.moviesclone.presentation.components.LoadingDialog

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel: HomeViewModel = koinScreenModel()
        val state by viewModel.state.collectAsState()

        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(6.dp)
                .background(color = surfaceLight)
        ) {
            if (state.isLoading) {
                item {
                    LoadingDialog(show = true)
                }
            } else {
                item {
                    HomeUpcomingMoviesSection(
                        moviesList = state.upcomingMovies.take(10),
                        sectionTitle = "UPCOMING MOVIES"
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(24.dp))
                }
                item {
                    HomeMoviesSection(
                        moviesList = state.popularMovies.take(10),
                        sectionTitle = "POPULAR MOVIES",
                        sectionSubTitle = "Top 10 popular movies"
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(24.dp))
                }
                item {
                    HomeMoviesSection(
                        moviesList = state.topRatedMovies.take(10),
                        sectionTitle = "TOP RATED MOVIES",
                        sectionSubTitle = "Top 10 top rated movies"
                    )
                }
            }
        }
    }
}