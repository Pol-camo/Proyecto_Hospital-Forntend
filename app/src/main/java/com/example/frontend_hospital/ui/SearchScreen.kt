
package com.example.frontend_hospital.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SearchScreen(onBack: () -> Unit) {
    Column {
        Text("Búsqueda")
        Button(onClick = onBack) { Text("Volver") }
    }
}