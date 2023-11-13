package com.yy.codebasecase.ui.screens.propertydetail

import com.yy.codebasecase.domain.model.Property

data class PropertyDetailState(
    val property: Property? = null,
    val error: String = ""
)
