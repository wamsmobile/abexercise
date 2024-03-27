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


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DistanceCalculatorApp()
        }
    }
}

@Composable
fun DistanceCalculatorApp(viewModel: DistanceViewModel = viewModel(factory = DistanceViewModelFactory())) {
    val distanceResult by viewModel.distanceResult.collectAsState()
    var latitude1 by remember { mutableStateOf("") }
    var longitude1 by remember { mutableStateOf("") }
    var latitude2 by remember { mutableStateOf("") }
    var longitude2 by remember { mutableStateOf("") }

    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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

