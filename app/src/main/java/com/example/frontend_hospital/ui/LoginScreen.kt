package com.example.frontend_hospital.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun LoginScreen(onBack: () -> Unit) {
    Column {
        Text("Login")
        Button(onClick = onBack) { Text("Volver") }
    }
}

