package com.example.frontend_hospital.ui

import androidx.compose.runtime.*

enum class Pantalla { HOME, LOGIN, LISTA, BUSQUEDA }

@Composable
fun AppNavigation() {
    var pantalla by remember { mutableStateOf(Pantalla.HOME) }

    when (pantalla) {
        Pantalla.HOME -> HomeScreen(
            onGoLogin = { pantalla = Pantalla.LOGIN },
            onGoList = { pantalla = Pantalla.LISTA },
            onGoSearch = { pantalla = Pantalla.BUSQUEDA }
        )
        Pantalla.LOGIN -> LoginScreen(onBack = { pantalla = Pantalla.HOME })
        Pantalla.LISTA -> NurseListScreen(onBack = { pantalla = Pantalla.HOME })
        Pantalla.BUSQUEDA -> SearchScreen(onBack = { pantalla = Pantalla.HOME })
    }
}