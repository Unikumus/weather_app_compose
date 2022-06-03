package com.example.weather_1.domain.model

data class FiveDayForecast(
    val city: String = "",
    val list: List<HourForecast> = emptyList()
)
