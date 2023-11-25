package com.example.nuevo_amanecer_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.nuevo_amanecer_app.ViewModels.MatrizViewModel

@Composable
fun HomeScreen(navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(

        ){
            Button(
                modifier = Modifier
                    .width(500.dp)
                    .height(500.dp)
                    .padding(20.dp),
                onClick = {
                    navController.navigate("Tablero")
                },
                colors = ButtonDefaults.buttonColors( containerColor = Color(android.graphics.Color.parseColor("#5BC0EB")) ),
                shape = ButtonDefaults.elevatedShape
            ){
                Text(text = "Ir a Tablero", fontSize = 70.sp)
            }

            Button(
                modifier = Modifier
                    .width(500.dp)
                    .height(500.dp)
                    .padding(20.dp),
                onClick = {
                    navController.navigate("editarTablero")
                },
                colors = ButtonDefaults.buttonColors( containerColor = Color(android.graphics.Color.parseColor("#CDE7B0")) )
            ){
                Text(text = "Editar Tablero", fontSize = 60.sp)
            }
        }
    }

}