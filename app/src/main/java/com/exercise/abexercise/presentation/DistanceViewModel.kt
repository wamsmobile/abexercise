package com.exercise.abexercise.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exercise.abexercise.domain.CalculateDistanceUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for managing UI-related data and operations for distance calculations.
 *
 * This ViewModel interacts with the CalculateDistanceUseCase to perform distance calculations
 * between two geographic points based on their latitude and longitude values.
 * It provides a reactive way to observe calculation results through a StateFlow.
 *
 * @property calculateDistanceUseCase The use case responsible for calculating the distance between two points.
 */
class DistanceViewModel(private val calculateDistanceUseCase: CalculateDistanceUseCase) : ViewModel() {

    // Private mutable state flow for holding the distance calculation result.
    private val _distanceResult = MutableStateFlow<String?>(null)
    // Public read-only state flow to be observed by the UI for distance calculation results.
    val distanceResult: StateFlow<String?> = _distanceResult

    /**
     * Initiates the calculation of the distance between two geographic points.
     *
     * The function takes four strings representing the latitude and longitude of two points,
     * converts them to doubles, and uses the CalculateDistanceUseCase to compute the distance.
     * The result is posted to the _distanceResult state flow.
     * If the input is not valid or the calculation fails, an error message is posted instead.
     *
     * @param lat1 Latitude of the first point.
     * @param lon1 Longitude of the first point.
     * @param lat2 Latitude of the second point.
     * @param lon2 Longitude of the second point.
     */
    fun calculateDistance(lat1: String, lon1: String, lat2: String, lon2: String) {
        viewModelScope.launch {
            try {
                // Convert string inputs to double and calculate the distance.
                val result = calculateDistanceUseCase(lat1.toDouble(), lon1.toDouble(), lat2.toDouble(), lon2.toDouble())
                // Update the state flow with the formatted result.
                _distanceResult.value = "%.2f km".format(result)
            } catch (e: Exception) {
                // On error (e.g., invalid input), update the state flow with an error message.
                _distanceResult.value = "Invalid input"
            }
        }
    }
}