package com.example.weather_1.data.repository

import android.util.Log
import com.example.weather_1.common.Constants.Companion.API_KEY
import com.example.weather_1.common.Constants.Companion.TAG
import com.example.weather_1.common.service.GpsTrackerMock
import com.example.weather_1.data.remoute.WeatherApi
import com.example.weather_1.data.remoute.dto.day_forecast_dto.WeatherFiveDayResponse
import com.example.weather_1.data.remoute.dto.week_forecast_dto.DailyDto
import com.example.weather_1.data.remoute.dto.week_forecast_dto.ForecastResponse
import com.example.weather_1.domain.repository.WeatherRepository
import javax.inject.Inject


class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi,
    private  val gpsTracker : GpsTrackerMock,
): WeatherRepository {

    override suspend fun getWeatherFiveDay(): WeatherFiveDayResponse {

        val loc = getLocation()



        val resp = api.getWeatherFiveDay(
        key = API_KEY,
        lon = loc.longitude.toString(),
        lat =  loc.latitude.toString(),
        )

        val response: WeatherFiveDayResponse = WeatherFiveDayResponse(
            list =  resp.list,
            city = resp.city,
        )

        return response
    }


    override suspend fun getForecast(): List<DailyDto> {

       val loc = getLocation(  )

        val response: ForecastResponse = api.getForecast(
            key = API_KEY,
            lon = loc.longitude.toString(),
            lat =  loc.latitude.toString(),
            exclude = "current,minutely,hourly,alerts",
           )

        Log.w(TAG, "REST == ${response.daily.size}")
        return response.daily
    }


    fun getLocation(  ): UserLocation {

        if (gpsTracker.canGetLocation()) {

            return  UserLocation(
                latitude = gpsTracker.getLatitude1(),
                longitude = gpsTracker.getLongitude1()
            )

        } else {
            return  UserLocation(
                latitude = 0.0,
                longitude = 0.0,
            )
        }
    }

}

data class UserLocation (
    val latitude: Double,
    val longitude: Double
)

