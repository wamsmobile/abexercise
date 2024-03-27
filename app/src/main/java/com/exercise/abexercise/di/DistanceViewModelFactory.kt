package com.exercise.abexercise.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.exercise.abexercise.domain.CalculateDistanceUseCase
import com.exercise.abexercise.presentation.DistanceViewModel

class DistanceViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DistanceViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DistanceViewModel(CalculateDistanceUseCase()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}