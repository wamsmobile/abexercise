package com.exercise.abexercise.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.exercise.abexercise.di.DistanceViewModelFactory
import com.exercise.abexercise.presentation.DistanceViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import com.exercise.abexercise.ui.theme.AppThemeStyles


/**
 * The main activity that hosts the Compose UI for the application.
 * This activity sets up the content view with the DistanceCalculatorApp composable function,
 * which constructs the UI for calculating distances between two points.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DistanceCalculatorApp()
        }
    }
}

/**
 * Composable function that represents the main screen of the app.
 * It provides input fields for two sets of latitude and longitude, a button to calculate the distance,
 * and displays the result. It uses the DistanceViewModel for the calculation logic.
 *
 * @param viewModel The ViewModel that holds the logic for calculating the distance
 *                  and managing UI state. By default, it is initialized with DistanceViewModelFactory.
 */
@Composable
fun DistanceCalculatorApp(viewModel: DistanceViewModel = viewModel(factory = DistanceViewModelFactory())) {
    // State variables to store user input and the calculation result.
    val distanceResult by viewModel.distanceResult.collectAsState()
    var latitude1 by remember { mutableStateOf("") }
    var longitude1 by remember { mutableStateOf("") }
    var latitude2 by remember { mutableStateOf("") }
    var longitude2 by remember { mutableStateOf("") }

    // The Surface container uses the background color from the Material theme.
    Surface(color = MaterialTheme.colors.background) {
        // Column layout for vertically arranging the components.
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Input fields for latitude and longitude of two points.
            OutlinedTextField(
                value = latitude1,
                onValueChange = { latitude1 = it },
                label = { Text("Latitude 1", style = AppThemeStyles.labelTextStyle) },
                modifier = AppThemeStyles.textFieldModifier
            )
            OutlinedTextField(
                value = longitude1,
                onValueChange = { longitude1 = it },
                label = { Text("Longitude 1", style = AppThemeStyles.labelTextStyle) },
                modifier = AppThemeStyles.textFieldModifier
            )
            OutlinedTextField(
                value = latitude2,
                onValueChange = { latitude2 = it },
                label = { Text("Latitude 2", style = AppThemeStyles.labelTextStyle) },
                modifier = AppThemeStyles.textFieldModifier
            )
            OutlinedTextField(
                value = longitude2,
                onValueChange = { longitude2 = it },
                label = { Text("Longitude 2", style = AppThemeStyles.labelTextStyle) },
                modifier = AppThemeStyles.textFieldModifier
            )
            // Button that triggers the distance calculation.
            Button(
                onClick = { viewModel.calculateDistance(latitude1, longitude1, latitude2, longitude2) },
                modifier = AppThemeStyles.buttonModifier
            ) {
                Text("Calculate Distance")
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = distanceResult ?: "Distance will be shown here",
                style = AppThemeStyles.resultTextStyle,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

