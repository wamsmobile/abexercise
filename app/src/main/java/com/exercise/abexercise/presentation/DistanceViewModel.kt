package com.exercise.abexercise.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exercise.abexercise.domain.CalculateDistanceUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DistanceViewModel(private val calculateDistanceUseCase: CalculateDistanceUseCase) : ViewModel() {
    private val _distanceResult = MutableStateFlow<String?>(null)
    val distanceResult: StateFlow<String?> = _distanceResult

    fun calculateDistance(lat1: String, lon1: String, lat2: String, lon2: String) {
        viewModelScope.launch {
            try {
                val result = calculateDistanceUseCase(lat1.toDouble(), lon1.toDouble(), lat2.toDouble(), lon2.toDouble())
                _distanceResult.value = "%.2f km".format(result)
            } catch (e: Exception) {
                _distanceResult.value = "Invalid input"
            }
        }
    }
}