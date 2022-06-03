package com.example.weather_1.data.remoute.dto.week_forecast_dto

import com.example.weather_1.common.getDateTime
import com.example.weather_1.common.getTemperature
import com.example.weather_1.domain.model.Daily
import com.google.gson.annotations.SerializedName

data class DailyDto(
    val clouds: Int,
    @SerializedName("dew_point")
    val dewPoint: Double,
    val dt: Int,
    @SerializedName("feels_like")
    val feelsLike: FeelsLike,
    val humidity: Int,
    @SerializedName("moon_phase")
    val moonPhase: Double,
    val moonrise: Int,
    val moonset: Int,
    val pop: Double,
    val pressure: Int,
    val rain: Double,
    val sunrise: Int,
    val sunset: Int,
    val temp: Temp,
    val uvi: Double,
    val weather: List<Weather>,
    @SerializedName("wind_deg")
    val windDeg: Int,
    @SerializedName("wind_speed")
    val windSpeed: Double
)

fun DailyDto.toDaily(): Daily {
    return Daily(
        date = getDateTime(dt),
        pressure = pressure,
        temperature = getTemperature(temp.day),
        windSpeed = windSpeed,
        humidity = humidity,
        weather = weather
    )
}

