package com.example.weather_1.common

import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

val dec = DecimalFormat("##")

fun getDate(s: Int): String {
    return try {
        val sdf = SimpleDateFormat("dd MM yyyy", Locale.getDefault(Locale.Category.FORMAT))
        val netDate = Date(s.toLong() * 1000)
        sdf.format(netDate)
    } catch (e: Exception) {
        e.toString()
    }
}

fun getTemperature(temp: Double): String {
    return (dec.format(temp - 273.15)).toString()
}

fun getDateTime(s: Int): String {
    return try {
        val sdf = SimpleDateFormat("dd MM yyyy", Locale.getDefault(Locale.Category.FORMAT))
        val netDate = Date(s.toLong() * 1000)
        sdf.format(netDate)
    } catch (e: Exception) {
        e.toString()
    }
}

fun getTime(s: Int): String {
    return try {
        val sdf =  SimpleDateFormat("HH:mm", Locale.getDefault(Locale.Category.FORMAT))
        val netDate = Date(s.toLong() * 1000)
        sdf.format(netDate)
    } catch (e: Exception) {
        e.toString()
    }
}