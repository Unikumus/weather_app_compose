package com.example.weather_1.common.service

import android.location.Location

class GpsTrackerMock {

    // flag for GPS status
    var canGetLocation = true

    var location : Location? = null
    var latitude  = 55.751244 // Moscow latitude Moscow
    var longitude  = 37.618423 // Moscow longitude

    /** Function to get latitude */
    fun getLatitude1(): Double {
        if (location != null) {
            latitude = location!!.latitude
        }

        // return latitude
        return latitude
    }

    /** Function to get longitude */
    fun getLongitude1(): Double {
        if (location != null) {
            longitude = location!!.longitude
        }

        // return longitude
        return longitude
    }

    /**
     * Function to check GPS/wifi enabled
     * @return boolean
     */
    fun canGetLocation(): Boolean {
        return canGetLocation
    }


}