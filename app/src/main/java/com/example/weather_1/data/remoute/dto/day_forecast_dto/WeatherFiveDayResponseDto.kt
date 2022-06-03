package com.example.weather_1.data.remoute.dto.day_forecast_dto

data class WeatherFiveDayResponseDto(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<HourForecastDto>,
    val message: Int
)