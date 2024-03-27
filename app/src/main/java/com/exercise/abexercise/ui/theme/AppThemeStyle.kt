package com.exercise.abexercise.ui.theme

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object AppThemeStyles {
    val textFieldModifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 0.dp, vertical = 8.dp)

    val buttonModifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 0.dp, vertical = 8.dp)

    val resultTextStyle = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue
    )

    val labelTextStyle = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    )
}
