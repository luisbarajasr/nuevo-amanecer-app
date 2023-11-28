package com.example.nuevo_amanecer_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun JuegosMenuScreen(navController: NavController) {

    Button(
        modifier = Modifier.padding(20.dp),
        colors = ButtonDefaults.buttonColors( containerColor = Color(android.graphics.Color.parseColor("#D9D9D9")) ),
        onClick = {
            navController.navigate("MenuScreen")
        },
    ) {
        Icon(Icons.Default.ArrowBack, contentDescription = "asd", tint = Color.Black)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Column(
            modifier = Modifier
                .width(1000.dp),
        ) {
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .height(125.dp)
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(20.dp))
                    .background(color = Color(android.graphics.Color.parseColor("#FBECB2")))
                    .clickable(onClick = {
                        navController.navigate("JuegoSonidosScreen")
                    }),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Text(text = "Nivel 1: Sonidos", fontSize = 60.sp)
            }

            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .height(125.dp)
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(20.dp))
                    .background(color = Color(android.graphics.Color.parseColor("#87C4FF")))
                    .clickable(onClick = {
                        navController.navigate("Draggable")
                    }),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Text(text = "Nivel 2: Clasificar", fontSize = 60.sp)
            }

            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .height(125.dp)
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(20.dp))
                    .background(color = Color(android.graphics.Color.parseColor("#F875AA")))
                    .clickable(onClick = {
                        navController.navigate("Nivel3")
                    }),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Text(text = "Nivel 3: Cuadricula", fontSize = 60.sp)
            }

            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .height(125.dp)
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(20.dp))
                    .background(color = Color(android.graphics.Color.parseColor("#9ADE7B")))
                    .clickable(onClick = {
                    navController.navigate("Nivel4")
                }),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Text(text = "Nivel 4: Cuadricula con números", fontSize = 50.sp)
            }

        }
    }
}