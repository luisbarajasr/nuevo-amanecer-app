package com.example.nuevo_amanecer_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nuevo_amanecer_app.screens.HomeScreen
import com.example.nuevo_amanecer_app.tablero.Tablero
import com.example.nuevo_amanecer_app.tablero.editarTablero

@Composable
fun Navigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "HomeScreen" ){

        composable("HomeScreen"){
            HomeScreen(navController = navController)
        }

        composable("tablero"){
            Tablero()
        }

        composable("editarTablero"){
            editarTablero()
        }
    }
}