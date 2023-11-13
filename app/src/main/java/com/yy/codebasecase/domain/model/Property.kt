package com.yy.codebasecase.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Property(
    val bathCount: Int? = null,
    val buildingAge: String? = null,
    val category: String? = null,
    val city: String? = null,
    val createdDate: String? = null,
    @SerialName("curreny")
    val currency: String? = null,
    val description: String? = null,
    val district: String? = null,
    val gross: Int? = null,
    val images: List<String>? = null,
    val label: String? = null,
    val neighborhood: String? = null,
    val net: Int? = null,
    val price: String? = null,
    val room: String? = null,
    val roomCount: Int? = null
)