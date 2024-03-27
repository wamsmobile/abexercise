package com.exercise.abexercise

import android.location.Location
import com.exercise.abexercise.domain.CalculateDistanceUseCase
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class CalculateDistanceUseCaseTest {

    private lateinit var locationA: Location
    private lateinit var locationB: Location
    private lateinit var calculateDistanceUseCase: CalculateDistanceUseCase

    @Before
    fun setUp() {
        // Initialize your use case here
        calculateDistanceUseCase = CalculateDistanceUseCase()

        // Mock Location objects
        locationA = Mockito.mock(Location::class.java)
        locationB = Mockito.mock(Location::class.java)

        // Stub the getLatitude and getLongitude methods
        Mockito.`when`(locationA.latitude).thenReturn(40.712776)
        Mockito.`when`(locationA.longitude).thenReturn(-74.005974)
        Mockito.`when`(locationB.latitude).thenReturn(34.052235)
        Mockito.`when`(locationB.longitude).thenReturn(-118.243683)
    }

    @Test
    fun calculateDistance_returnsCorrectDistance() {
        // You might need to adjust this depending on your implementation
        val expectedDistanceKm = 3940.0

        // Calculate distance using the use case
        val result = calculateDistanceUseCase.invoke(locationA.latitude, locationA.longitude, locationB.latitude, locationB.longitude)

        // Assert the result
        assertEquals(expectedDistanceKm, result.toDouble(), 100.0) // The delta allows some margin for approximation
    }
}
