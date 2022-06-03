package com.example.weather_1.data.remoute

import com.example.weather_1.data.remoute.dto.day_forecast_dto.WeatherFiveDayResponseDto
import com.example.weather_1.data.remoute.dto.week_forecast_dto.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {


    @GET("/data/2.5/forecast?")
    suspend fun getWeatherFiveDay(
        @Query("appid")  key: String,
        @Query("lon")  lon: String,
        @Query("lat")  lat: String,
    ): WeatherFiveDayResponseDto


    @GET("/data/2.5/onecall?")
    suspend fun getForecast(
    @Query("appid")  key: String,
    @Query("exclude")  exclude: String,
    @Query("lon")  lon: String,
    @Query("lat")  lat: String,
    ): ForecastResponse
}