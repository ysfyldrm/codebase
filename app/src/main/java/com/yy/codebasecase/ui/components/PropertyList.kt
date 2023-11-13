package com.yy.codebasecase.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yy.codebasecase.domain.model.Property

@Composable
fun PropertyList(
    properties: List<Property>, onPropertyClick: (Property) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(properties, key = { property -> property.hashCode() }) { property ->
            PropertyItem(property = property, onClick = { onPropertyClick(property) })
        }
    }
}