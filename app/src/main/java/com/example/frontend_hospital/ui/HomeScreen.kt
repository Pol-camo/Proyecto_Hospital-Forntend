
package com.example.frontend_hospital.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(onGoLogin: () -> Unit, onGoList: () -> Unit, onGoSearch: () -> Unit) {
    Column {
        Text("Home")
        Button(onClick = onGoLogin) { Text("Login") }
        Button(onClick = onGoList) { Text("Lista") }
        Button(onClick = onGoSearch) { Text("Búsqueda") }
    }
}