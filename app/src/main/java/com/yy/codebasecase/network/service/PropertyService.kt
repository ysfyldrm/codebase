package com.yy.codebasecase.network.service

import com.yy.codebasecase.domain.model.PropertyResponse
import com.yy.codebasecase.network.client.KtorClient

class PropertyService(client: KtorClient) : BaseService(client) {
    suspend fun getProperties(): PropertyResponse {
        return get("/android-test-case.json")
    }
}