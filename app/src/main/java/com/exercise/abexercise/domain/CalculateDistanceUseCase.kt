package com.exercise.abexercise.domain

import android.location.Location

class CalculateDistanceUseCase {
    operator fun invoke(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Float {
        val location1 = Location("").apply {
            latitude = lat1
            longitude = lon1
        }
        val location2 = Location("").apply {
            latitude = lat2
            longitude = lon2
        }
        return location1.distanceTo(location2) / 1000 // Distance in kilometers
    }
}