package com.exercise.abexercise.domain

import android.location.Location

/**
 * Use case for calculating the geographic distance between two points.
 *
 * This class encapsulates the logic for determining the distance between two geographic locations
 * defined by their latitude and longitude coordinates. The calculation is performed using the Android
 * Location API, which provides a method to calculate the straight-line distance between two points.
 *
 * The distance is calculated "as the crow flies", meaning it represents the shortest path between
 * the two points in a straight line, ignoring any potential obstacles or variations in terrain.
 */
class CalculateDistanceUseCase {
    /**
     * Calculates the distance between two points specified by their latitude and longitude.
     *
     * The distance is returned as a float representing the distance in kilometers.
     * This method utilizes the Android Location API's `distanceTo` function for the calculation,
     * dividing the result by 1000 to convert from meters to kilometers.
     *
     * @param lat1 Latitude of the first point in decimal degrees.
     * @param lon1 Longitude of the first point in decimal degrees.
     * @param lat2 Latitude of the second point in decimal degrees.
     * @param lon2 Longitude of the second point in decimal degrees.
     * @return The calculated distance between the two points in kilometers.
     */
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