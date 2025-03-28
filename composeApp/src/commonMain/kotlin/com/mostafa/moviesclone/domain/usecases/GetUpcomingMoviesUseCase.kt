package com.mostafa.moviesclone.domain.usecases

import com.mostafa.moviesclone.domain.RequestState
import com.mostafa.moviesclone.domain.models.MoviesModel
import com.mostafa.moviesclone.domain.repository.HomeRepo
import kotlinx.coroutines.flow.Flow

class GetUpcomingMoviesUseCase(private val homeRepo: HomeRepo) {
    suspend operator fun invoke(): Flow<RequestState<List<MoviesModel>>> {
        return homeRepo.getUpcomingMovies()
    }
}