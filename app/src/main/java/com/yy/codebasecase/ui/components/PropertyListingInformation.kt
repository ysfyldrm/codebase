package com.yy.codebasecase.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
fun PropertyListingInformation(property: Property) {
    Column(modifier = Modifier.padding(vertical = 12.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${property.price} ${property.currency}",
                fontSize = 20.sp,
                lineHeight = 30.sp,
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme.primary,
            )
            Text(
                text = property.createdDate ?: "",
                fontSize = 12.sp,
                lineHeight = 14.sp,
                fontWeight = FontWeight(400),
                color = MaterialTheme.colorScheme.primary
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "${property.city} / ${property.district} / ${property.neighborhood} ",
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(400),
                color = MaterialTheme.colorScheme.primary
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            property.roomCount?.let {
                Text(
                    text = stringResource(id = R.string.room, it),
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.primary
                )
            }
            property.bathCount?.let {
                Text(
                    text = stringResource(id = R.string.bath, it),
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.primary
                )
            }
            property.gross?.let {
                Text(
                    text = stringResource(id = R.string.gross_m2, it),
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.primary
                )
            }
            property.net?.let {
                Text(
                    text = stringResource(id = R.string.net_m2, it),
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}