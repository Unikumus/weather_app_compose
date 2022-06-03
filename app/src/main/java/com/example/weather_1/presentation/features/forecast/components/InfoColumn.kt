package com.example.weather_1.presentation.features.forecast.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weather_1.common.components.InfoItem
import com.example.weather_1.common.components.InfoItemType
import com.example.weather_1.domain.model.Daily

@Composable
fun InfoColumn(day: Daily) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .height(120.dp)
            .padding(16.dp)
    ){
        InfoItem(
            iconType =  InfoItemType.PRESSURE,
            value = day.pressure.toString(),
            suffix = "mp")

        InfoItem(
            iconType =  InfoItemType.WIND,
            value = day.windSpeed.toString(),
            suffix = "m/s")

        InfoItem(
            iconType =  InfoItemType.HUMIDITY,
            value = day.humidity.toString(),
            suffix = "%")
    }

}
