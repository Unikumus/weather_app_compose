package com.example.weather_1.presentation.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val blue1 = Color(0xFF51ADFC)
val blue2 = Color(0xFF4094E9)

val circleGradient = Brush.verticalGradient(
    colors = listOf(
        Color.White.copy(alpha = 0.1f),
        Color.White.copy(alpha = 0.35f),
    )
)

val gradient = Brush.verticalGradient(
    colors = listOf(
        blue1,
        blue2
    )
)

