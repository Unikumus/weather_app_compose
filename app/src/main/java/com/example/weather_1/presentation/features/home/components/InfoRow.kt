package com.example.weather_1.presentation.features.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weather_1.common.components.InfoItem
import com.example.weather_1.common.components.InfoItemType
import com.example.weather_1.presentation.features.home.DayWeatherState

@Composable
fun InfoRow(state: DayWeatherState) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 40.dp, end = 40.dp)
    ){

        InfoItem(
            iconType =  InfoItemType.PRESSURE,
            value = state.forecast.list[0].pressure.toString(),
            suffix = "mp")

        InfoItem(
            iconType =  InfoItemType.WIND,
            value = state.forecast.list[0].wind.speed.toString(),
            suffix = "m/s")

        InfoItem(
            iconType =  InfoItemType.HUMIDITY,
            value = state.forecast.list[0].humidity.toString(),
            suffix = "%")
    }
}