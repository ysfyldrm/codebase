package com.yy.codebasecase.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yy.codebasecase.R
import com.yy.codebasecase.domain.model.Property


@Composable
fun PropMainDetailInformation(property: Property) {
    Column(
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, top = 24.dp)

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = property.category ?: "",
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                lineHeight = 20.sp,
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = property.createdDate ?: "",
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                lineHeight = 14.sp,
                color = MaterialTheme.colorScheme.primary
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "${property.price} ${property.currency}",
            fontSize = 20.sp,
            lineHeight = 30.sp,
            fontWeight = FontWeight(700),
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            InfoItem(
                label = stringResource(id = R.string.room_count),
                value = property.room ?: ""
            )
            InfoItem(
                label = stringResource(id = R.string.building_age),
                value = property.buildingAge ?: ""
            )
            InfoItem(
                label = stringResource(id = R.string.gross_area),
                value = "${property.gross} m²"
            )
            InfoItem(
                label = stringResource(id = R.string.net_area),
                value = "${property.net} m²"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_checklist),
                    contentDescription = null,
                    tint = Color.Unspecified

                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(id = R.string.all_features),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700),
                    lineHeight = 16.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(id = R.string.review),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 16.sp,
                    color = Color(0xFF0067A0)
                )
                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    painter = painterResource(id = R.drawable.ic_angle_right),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}