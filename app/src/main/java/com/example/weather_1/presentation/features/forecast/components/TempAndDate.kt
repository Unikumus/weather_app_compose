package com.example.weather_1.presentation.features.forecast.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_1.domain.model.Daily

@Composable
fun TempAndDate(day: Daily) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .height(120.dp)
            .padding(16.dp)) {

        Text(
            text = day.date,
            color = Color.White.copy(alpha = 0.9f),
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
        )

        // current temperature
        Text(
            text = buildAnnotatedString {
                append(
                    AnnotatedString(
                        day.temperature,
                        spanStyle = SpanStyle(
                            Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Black,
                        )
                    )
                )

                append(
                    AnnotatedString(
                        "°С",
                        spanStyle = SpanStyle(
                            Color.White,
                            fontSize = 12.sp,
                            baselineShift = BaselineShift(0.5f)
                        )
                    )
                )
            },

            modifier = Modifier.padding(top = 20.dp)

        )
    }
}