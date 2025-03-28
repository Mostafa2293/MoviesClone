package com.mostafa.moviesclone.presentation.Home

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.mostafa.moviesclone.domain.RequestState
import com.mostafa.moviesclone.domain.usecases.GetPopularMoviesUseCase
import com.mostafa.moviesclone.domain.usecases.GetTopRatedMoviesUseCase
import com.mostafa.moviesclone.domain.usecases.GetUpcomingMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel(
    private val popularMoviesUseCase: GetPopularMoviesUseCase,
    private val topRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val upcomingMoviesUseCase: GetUpcomingMoviesUseCase,
) : ScreenModel {
    private val _state = MutableStateFlow(HomeDataState())
    val state: StateFlow<HomeDataState> = _state

    init {
        getHomeData()
    }

    private fun getHomeData() {
        getPopularMovies()
        getTopRatedMovies()
        getUpcomingMovies()
    }

    private fun getPopularMovies() {
        screenModelScope.launch {
            popularMoviesUseCase()
                .onStart { _state.value = _state.value.copy(isLoading = true) }
                .collect { result ->
                    when (result) {
                        is RequestState.Success -> {
                            _state.value = _state.value.copy(
                                isLoading = false,
                                popularMovies = result.data
                            )
                        }

                        is RequestState.Error -> {
                            _state.value = _state.value.copy(isLoading = false)
                            // Handle error state if needed
                        }

                        RequestState.Loading -> {}
                    }
                }
        }
    }

    private fun getTopRatedMovies() {
        screenModelScope.launch {
            topRatedMoviesUseCase()
                .onStart { _state.value = _state.value.copy(isLoading = true) }
                .collect { result ->
                    when (result) {
                        is RequestState.Success -> {
                            _state.value = _state.value.copy(
                                isLoading = false,
                                topRatedMovies = result.data
                            )
                        }

                        is RequestState.Error -> {
                            _state.value = _state.value.copy(isLoading = false)
                            // Handle error state if needed
                        }

                        RequestState.Loading -> {}
                    }
                }
        }
    }

    private fun getUpcomingMovies() {
        screenModelScope.launch {
            upcomingMoviesUseCase()
                .onStart { _state.value = _state.value.copy(isLoading = true) }
                .collect { result ->
                    when (result) {
                        is RequestState.Success -> {
                            _state.value = _state.value.copy(
                                isLoading = false,
                                upcomingMovies = result.data
                            )
                        }

                        is RequestState.Error -> {
                            _state.value = _state.value.copy(isLoading = false)
                            // Handle error state if needed
                        }

                        RequestState.Loading -> {}
                    }
                }
        }
    }
}