package com.mostafa.moviesclone.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.surfaceLight
import com.mostafa.moviesclone.presentation.Home.HomeDataState
import com.mostafa.moviesclone.util.Constants.UI.MOVIES
import com.mostafa.moviesclone.util.Constants.UI.TV

@Composable
fun HomeMoviesItems(
    state: HomeDataState,
    paddingValues: PaddingValues,
    selectedSegmentValue: String
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(color = surfaceLight),
        contentPadding = PaddingValues(
            top = paddingValues.calculateTopPadding(), // Column moves up as the discount hides
            bottom = paddingValues.calculateBottomPadding(),
            start = 4.dp,
            end = 4.dp
        )
    ) {
        if (selectedSegmentValue == MOVIES) {
            if (state.isMoviesLoading) {
                item {
                    LoadingDialog(show = true)
                }
            } else {
                item {
                    HomeCarouselSection(
                        moviesList = state.upcomingMovies.take(10),
                        sectionTitle = "UPCOMING MOVIES"
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(24.dp))
                }
                item {
                    HomeScrollableSection(
                        moviesList = state.popularMovies.take(10),
                        sectionTitle = "POPULAR MOVIES",
                        sectionSubTitle = "POPULAR 10 MOVIES"
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(24.dp))
                }
                item {
                    HomeScrollableSection(
                        moviesList = state.topRatedMovies.take(10),
                        sectionTitle = "TOP RATED MOVIES",
                        sectionSubTitle = "Top RATED 10 MOVIES"
                    )
                }
            }
        } else if (selectedSegmentValue == TV) {
            if (state.isTvLoading) {
                item {
                    LoadingDialog(show = true)
                }
            } else {
                item {
                    HomeCarouselSection(
                        moviesList = state.onTheAirTv.take(10),
                        sectionTitle = "ON THE AIR TV SHOWS"
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(24.dp))
                }
                item {
                    HomeScrollableSection(
                        moviesList = state.popularTv.take(10),
                        sectionTitle = "POPULAR TV SHOWS",
                        sectionSubTitle = "POPULAR 10 TV SHOWS"
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(24.dp))
                }
                item {
                    HomeScrollableSection(
                        moviesList = state.topRatedTv.take(10),
                        sectionTitle = "TOP RATED TV SHOWS",
                        sectionSubTitle = "Top 10 RATED TV SHOWS"
                    )
                }
            }
        }
    }
}