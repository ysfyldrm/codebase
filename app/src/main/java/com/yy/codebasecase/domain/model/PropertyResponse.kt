package com.yy.codebasecase.domain.model

import kotlinx.serialization.Serializable

/**
 * API'den alınan ilanların listesini içeren response
 */
@Serializable
data class PropertyResponse(
    val data: List<Property>
)
