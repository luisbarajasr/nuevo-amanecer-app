package com.example.nuevo_amanecer_app.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nuevo_amanecer_app.ViewModels.MatrizViewModel
import com.example.nuevo_amanecer_app.paginas.juegos.GamePrev
import com.example.nuevo_amanecer_app.paginas.juegos.Nivel3y4
import com.example.nuevo_amanecer_app.screens.HomeScreen
import com.example.nuevo_amanecer_app.screens.JuegosMenuScreen
import com.example.nuevo_amanecer_app.screens.MenuScreen
import com.example.nuevo_amanecer_app.tablero.Tablero
import com.example.nuevo_amanecer_app.tablero.editarTablero

@Composable
fun Navigation(){

    val navController = rememberNavController()
    val matricesViewModel : MatrizViewModel = viewModel()

    NavHost(navController = navController, startDestination = "MenuScreen" ){

        composable("MenuScreen"){
            MenuScreen(navController = navController)
            //editarTablero(navController = navController)
        }

        composable("HomeScreen") {
            HomeScreen(navController = navController)
        }

        composable("tablero"){
            Tablero(navController = navController, matricesViewModel)
        }

        composable("editarTablero"){
            editarTablero(navController = navController, matricesViewModel)
        }

        composable("Nivel3y4"){
            Nivel3y4(navController = navController)
        }

        composable("Draggable"){
            GamePrev(navController = navController)
        }

        composable("JuegosMenuScreen"){
            JuegosMenuScreen(navController = navController)
        }
    }
}