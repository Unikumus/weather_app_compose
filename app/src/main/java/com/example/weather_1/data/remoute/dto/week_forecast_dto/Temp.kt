package com.example.weather_1.data.remoute.dto.week_forecast_dto

data class Temp(
    val day: Double,
    val eve: Double,
    val max: Double,
    val min: Double,
    val morn: Double,
    val night: Double
)