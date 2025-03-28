package com.mostafa.moviesclone.data

import com.mostafa.moviesclone.util.Constants.Api.API_KEY
import com.mostafa.moviesclone.util.Constants.Api.AUTHORIZATION
import com.mostafa.moviesclone.util.Constants.Api.BASE_URL
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

object NetworkService {
    val httpClient = HttpClient {
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
            logger = Logger.SIMPLE
            level = LogLevel.ALL
        }
    }

    suspend inline fun <reified T> get(url: String): T {
        return httpClient.get(url).body()
    }
}