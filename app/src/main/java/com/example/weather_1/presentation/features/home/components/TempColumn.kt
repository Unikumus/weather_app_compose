package com.example.weather_1.presentation.features.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.weather_1.common.Constants.Companion.ICON_PATH
import com.example.weather_1.domain.model.HourForecast

@Composable
fun TempColumn(day: HourForecast){

    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.White.copy(alpha = 0.2f),
        elevation = 0.dp,
        modifier = Modifier
            .padding(4.dp)

    ){

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .height(120.dp)
                .width(70.dp)
                .padding(4.dp)) {


            Text(
                text = "${day.temperature}° С",
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Black
            )


            Image(
                painter = rememberImagePainter(
                    "$ICON_PATH${day.weather[0].icon}@4x.png"),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )

            Text(
                text = day.time,
                color = Color.White.copy(alpha = 0.9f),
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
            )
        }
    }


}