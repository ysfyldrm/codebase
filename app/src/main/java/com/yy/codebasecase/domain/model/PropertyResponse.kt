package com.yy.codebasecase.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class PropertyResponse(
    val data: List<Property>
)
