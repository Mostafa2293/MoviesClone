package com.mostafa.moviesclone.presentation.Home

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import com.mostafa.moviesclone.presentation.components.HomeMoviesItems
import com.mostafa.moviesclone.presentation.components.HomeTopBar
import com.mostafa.moviesclone.util.Constants.UI.MOVIES

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel: HomeViewModel = koinScreenModel()
        val state by viewModel.state.collectAsState()
        val selectedSegment = remember { mutableStateOf(MOVIES) }

        // Observe changes to selectedSegment
        LaunchedEffect(selectedSegment.value) {
            if (selectedSegment.value == "TV") {
                viewModel.onTvSegmentClicked()
            }
        }
        Scaffold(
            topBar = {
                HomeTopBar(selectedSegment = selectedSegment)
            }
        ) {
            HomeMoviesItems(
                state = state,
                paddingValues = it,
                selectedSegmentValue = selectedSegment.value
            )
        }

    }

}
