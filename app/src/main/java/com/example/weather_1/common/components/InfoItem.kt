package com.example.weather_1.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_1.R

enum class InfoItemType { HUMIDITY, PRESSURE, WIND }

fun getInfoIcon(iconType: InfoItemType) =
    when(iconType){
        InfoItemType.HUMIDITY -> R.drawable.ic_humidity
        InfoItemType.PRESSURE -> R.drawable.ic_pressure
        InfoItemType.WIND -> R.drawable.ic_wind
    }

@Composable
fun InfoItem(
    value: String,
    suffix: String,
    iconType: InfoItemType) {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
    ){


        Image(
            painter = painterResource(id = getInfoIcon(iconType)),
            contentDescription = "icon",
            modifier = Modifier.size(20.dp)
        )

        Text(
            text = buildAnnotatedString {

                append(
                    AnnotatedString(
                    "$value ",
                    spanStyle = SpanStyle(
                    Color.White, fontSize = 18.sp,
                    fontWeight = FontWeight.Black)
                    )
                )

                append(
                    AnnotatedString(
                    suffix,
                    spanStyle = SpanStyle(
                        Color.White,
                        fontSize = 10.sp,)
                    )
                )
            },

            modifier = Modifier
                .padding(start = 10.dp)

        )
    }
}

