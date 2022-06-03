package com.example.weather_1.domain.model

import com.example.weather_1.data.remoute.dto.week_forecast_dto.Weather

data class Daily(
    val date: String,
    val humidity: Int,
    val pressure: Int,
    val temperature: String,
    val windSpeed: Double,
    val weather: List<Weather>
)
