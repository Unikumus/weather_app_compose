package com.example.weather_1.presentation.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

class CustomShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            lineTo(size.width, 0f);
            cubicTo(size.width, 0f, size.width, size.height * 0.78f, size.width, size.height * 0.78f);
            cubicTo(size.width * 0.87f, size.height * 0.92f, size.width * 0.7f, size.height, size.width / 2, size.height);
            cubicTo(size.width * 0.31f, size.height, size.width * 0.13f, size.height * 0.92f, size.width * 0.01f, size.height * 0.79f);
            cubicTo(size.width * 0.01f, size.height * 0.79f, 0f, size.height * 0.79f, 0f, size.height * 0.78f);
            cubicTo(0f, size.height * 0.78f, 0f, 0f, 0f, 0f);
            cubicTo(0f, 0f, size.width, 0f, size.width, 0f);
            close()
        }
        return Outline.Generic(path)
    }
}