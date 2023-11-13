package com.yy.codebasecase.network.service

import com.yy.codebasecase.BuildConfig
import com.yy.codebasecase.network.client.KtorClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

/**
 * Ktor client ile HTTP GET ve POST işlemlerini kolaylaştıran temel servis sınıfı.
 */
abstract class BaseService(protected val client: KtorClient) {

    protected suspend inline fun <reified T> get(endpoint: String): T {
        return client.httpClient.get("${BuildConfig.API_ENDPOINT}$endpoint").body<T>()
    }

    protected suspend inline fun <reified T> post(endpoint: String, body: Any): T {
        return client.httpClient.post("${BuildConfig.API_ENDPOINT}$endpoint") {
            contentType(ContentType.Application.Json)
            setBody(body)
        }.body<T>()
    }
}