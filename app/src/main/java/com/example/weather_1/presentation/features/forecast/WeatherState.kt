package com.example.weather_1.presentation.features.forecast

import com.example.weather_1.domain.model.Daily

data class WeatherState(
    val forecast: List<Daily> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "",
)
