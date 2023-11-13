package com.yy.codebasecase.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yy.codebasecase.R
import com.yy.codebasecase.domain.model.Property

@Composable
fun PropDetailDescription(property: Property) {
    Spacer(modifier = Modifier.height(16.dp))
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Text(
            text = stringResource(id = R.string.description),
            fontSize = 18.sp,
            fontWeight = FontWeight(700),
            lineHeight = 22.sp,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = property.description ?: "",
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            lineHeight = 16.sp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}