package com.yy.codebasecase.network.client

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.UserAgent
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * HTTP Client için global ayarları içeren singleton nesne.
 */
object KtorClient {

    // JSON serialization için yapılandırma.
    private val serializeJson = Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
    }

    // HttpClient örneği, lazy ile yalnızca kullanıldığında oluşturulur.
    val httpClient: HttpClient by lazy {
        HttpClient {

            // JSON serileştirme özelliğini
            install(ContentNegotiation) {
                json(
                    json = serializeJson,
                    contentType = ContentType.Any
                )
            }

            // Otomatik yeniden deneme özelliğini
            install(HttpRequestRetry) {
                retryOnServerErrors(3)
                exponentialDelay(maxDelayMs = 5000)
                modifyRequest { request ->
                    request.headers.append("x-retry-count", 2.toString())
                }
            }
            // UserAgent özelliğini
            install(UserAgent) {
                agent = "CodeBase YY Case"
            }

            // İstek loglama özelliği
            install(Logging) {
                logger = Logger.ANDROID
                level = LogLevel.ALL
            }

            // İstek ve yanıt gözlemcisi
            ResponseObserver {
                val timeDifference = it.responseTime.timestamp - it.requestTime.timestamp
                val protocolVersion = it.version
                println("HTTP status: ${it.status}\nTime Diff: $timeDifference \nProtocol Version: $protocolVersion")

            }
        }
    }
}