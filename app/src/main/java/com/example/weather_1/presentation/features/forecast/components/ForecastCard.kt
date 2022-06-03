package com.example.weather_1.presentation.features.forecast.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.weather_1.common.Constants.Companion.ICON_PATH
import com.example.weather_1.domain.model.Daily

@Composable
fun ForecastCard(day: Daily) {

    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.White.copy(alpha = 0.2f),
        elevation = 0.dp,
        modifier = Modifier
               .padding(16.dp)
    ){
       Row(
           horizontalArrangement = Arrangement.SpaceBetween,
           modifier = Modifier
               .padding(16.dp)
               .fillMaxWidth()
       ){

           TempAndDate(day = day)
           InfoColumn(day = day)
           Image(
               painter = rememberImagePainter("$ICON_PATH${day.weather[0].icon}@2x.png"),
               contentDescription = null,
               modifier = Modifier.size(70.dp)
           )
       }
    }


}




