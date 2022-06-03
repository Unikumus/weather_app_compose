package com.example.weather_1.data.remoute.dto.day_forecast_dto

import com.example.weather_1.common.getDate
import com.example.weather_1.common.getTemperature
import com.example.weather_1.common.getTime
import com.example.weather_1.domain.model.HourForecast

data class HourForecastDto(
    val clouds: Clouds,
    val dt: Int,
    val dt_txt: String,
    val main: Main,
    val pop: Double,
    val sys: Sys,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)

fun HourForecastDto.toHourForecast(): HourForecast {
    return HourForecast(
        clouds = clouds,
        date = getDate(dt),
        temperature = getTemperature(main.temp),
        weather = weather,
        wind = wind,
        humidity = main.humidity,
        pressure = main.pressure,
        time = getTime(dt)
    )
}



