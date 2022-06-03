package com.example.weather_1.data.remoute.dto.day_forecast_dto

data class WeatherFiveDayResponse (
    val city: City,
    val list: List<HourForecastDto>
)