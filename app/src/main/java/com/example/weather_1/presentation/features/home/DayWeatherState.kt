package com.example.weather_1.presentation.features.home

import com.example.weather_1.domain.model.FiveDayForecast

class DayWeatherState (
    val forecast: FiveDayForecast = FiveDayForecast(),
    val isLoading: Boolean = false,
    val error: String = "",
)