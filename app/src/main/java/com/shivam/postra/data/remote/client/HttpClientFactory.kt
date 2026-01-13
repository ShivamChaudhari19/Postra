package com.shivam.postra.data.remote.client

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.HttpTimeoutConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object HttpClientFactory {
    fun create(engine: OkHttp): HttpClient{
        return HttpClient {

            install(ContentNegotiation){
                json(
                    json=Json {
                        ignoreUnknownKeys = true
                        isLenient=true
                    },
                    contentType = ContentType.Application.Any
                )
            }
            install(HttpTimeout){
                HttpTimeoutConfig(
                    requestTimeoutMillis=20000L,
                    socketTimeoutMillis=20000L
                )
            }
            install(Logging){
                level= LogLevel.ALL
                logger=Logger.Companion.ANDROID
            }
            defaultRequest {
                contentType(ContentType.Application.Any)
            }
            expectSuccess=false
        }


    }
}