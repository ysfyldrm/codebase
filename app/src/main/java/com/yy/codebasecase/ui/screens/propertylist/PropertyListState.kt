package com.yy.codebasecase.ui.screens.propertylist

import com.yy.codebasecase.domain.model.Property

data class PropertyListState(
    val isLoading: Boolean = false,
    val properties: List<Property> = emptyList(),
    val error: String = "",
    val searchQuery: String = "",
    val filteredProperties: List<Property> = emptyList()
)
