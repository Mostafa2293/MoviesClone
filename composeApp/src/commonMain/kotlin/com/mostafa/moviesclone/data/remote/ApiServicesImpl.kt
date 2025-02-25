package com.mostafa.moviesclone.data.remote

import com.mostafa.moviesclone.data.dto.PopularMoviesDto
import com.mostafa.moviesclone.domain.ApiServices
import com.mostafa.moviesclone.domain.RequestState
import com.mostafa.moviesclone.domain.models.PopularMoviesModel
import com.mostafa.moviesclone.util.Constants.Api.API_KEY
import com.mostafa.moviesclone.util.Constants.Api.AUTHORIZATION
import com.mostafa.moviesclone.util.Constants.Api.BASE_URL
import com.mostafa.moviesclone.util.Constants.Api.POPULAR_MOVIES_URL
import com.mostafa.moviesclone.util.Constants.Api.REQUEST_TIMEOUT
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class ApiServicesImpl : ApiServices {

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        install(HttpTimeout) {
            requestTimeoutMillis = REQUEST_TIMEOUT
        }
        install(DefaultRequest) {
            url(BASE_URL)
            headers {
                append(AUTHORIZATION, API_KEY)
            }
        }

        install(Logging) {
            logger = Logger.SIMPLE  // Uses the default logger
            level = LogLevel.ALL     // Logs everything (headers, body, etc.)
        }

    }

    override suspend fun getPopularMovies(): RequestState<List<PopularMoviesModel>> {
        return try {
            val response = httpClient.get(POPULAR_MOVIES_URL)
            val popularMoviesModel = response.body<PopularMoviesDto>().results.map { it.toDomain() }
            println("title: ${popularMoviesModel.first().title}")
            RequestState.Success(popularMoviesModel)
        } catch (e: Exception) {
            println("Error while fetching movies: ${e.message}")
            RequestState.Error("Error: ${e.message}")
        }
    }
}