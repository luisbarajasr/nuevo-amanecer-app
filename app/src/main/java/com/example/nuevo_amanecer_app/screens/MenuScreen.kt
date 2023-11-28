package com.example.nuevo_amanecer_app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .height(500.dp)
                        .width(500.dp)
                        .clip(shape = RoundedCornerShape(20.dp))
                        .background(color = Color(android.graphics.Color.parseColor("#FBECB2")))
                        .clickable(onClick = {
                            navController.navigate("HomeScreen")
                        }),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(Icons.Default.Menu, contentDescription = "vdfg", tint = Color.Black, modifier = Modifier.size(300.dp))
                }
                Text(text = "Tablero", fontSize = 50.sp)
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .height(500.dp)
                        .width(500.dp)
                        .clip(shape = RoundedCornerShape(20.dp))
                        .background(color = Color(android.graphics.Color.parseColor("#F1B4BB")))
                        .clickable(onClick = {
                            navController.navigate("JuegosMenuScreen")
                        }),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(Icons.Default.Home, contentDescription = "vdjfg", tint = Color.Black, modifier = Modifier.size(300.dp))
                }
                Text(text = "Juegos", fontSize = 50.sp)
            }

        }
    }
}