package com.example.nuevo_amanecer_app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController) {

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
                    navController.navigate("HomeScreen")
                },
                colors = ButtonDefaults.buttonColors( containerColor = Color(android.graphics.Color.parseColor("#CDE7B0")) ),
                shape = ButtonDefaults.textShape
            ){
                Text(text = "Tablero", fontSize = 70.sp)
            }

            ElevatedButton(
                modifier = Modifier
                    .width(500.dp)
                    .height(500.dp)
                    .padding(20.dp),
                onClick = {
                    navController.navigate("JuegosMenuScreen")
                },
                colors = ButtonDefaults.buttonColors( containerColor = Color(android.graphics.Color.parseColor("#45D5E9")) ),
            ){
                Text(text = "Juegos", fontSize = 60.sp)
            }
        }
    }
}