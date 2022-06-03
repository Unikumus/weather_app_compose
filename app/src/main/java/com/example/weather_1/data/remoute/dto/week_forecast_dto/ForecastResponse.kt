package com.example.weather_1.data.remoute.dto.week_forecast_dto

import com.google.gson.annotations.SerializedName

data class ForecastResponse(
    val daily: List<DailyDto>,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    @SerializedName("timezone_offset")
    val timezoneOffset: Int
)