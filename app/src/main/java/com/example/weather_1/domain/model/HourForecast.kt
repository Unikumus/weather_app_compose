package com.example.weather_1.domain.model

import com.example.weather_1.data.remoute.dto.day_forecast_dto.Clouds
import com.example.weather_1.data.remoute.dto.day_forecast_dto.Weather
import com.example.weather_1.data.remoute.dto.day_forecast_dto.Wind

data class HourForecast (
    val clouds: Clouds,
    val date: String,
    val temperature: String,
    val time: String,
    val weather: List<Weather>,
    val wind: Wind,
    val humidity: Int,
    val pressure: Int
    )