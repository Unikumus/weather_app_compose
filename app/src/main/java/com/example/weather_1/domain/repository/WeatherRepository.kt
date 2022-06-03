package com.example.weather_1.domain.repository

import com.example.weather_1.data.remoute.dto.day_forecast_dto.WeatherFiveDayResponse
import com.example.weather_1.data.remoute.dto.week_forecast_dto.DailyDto

interface WeatherRepository {

    suspend fun getWeatherFiveDay(): WeatherFiveDayResponse

    suspend fun getForecast(): List<DailyDto>
}