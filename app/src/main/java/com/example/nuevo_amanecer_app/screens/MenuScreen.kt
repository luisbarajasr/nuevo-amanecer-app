package com.example.nuevo_amanecer_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Tablero column
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .height(450.dp) // Reduced height to 450dp from 500dp
                        .width(450.dp) // Reduced width to 450dp from 500dp
                        .clip(shape = RoundedCornerShape(20.dp))
                        .background(color = Color(android.graphics.Color.parseColor("#FBECB2")))
                        .clickable(onClick = {
                            navController.navigate("HomeScreen")
                        }),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.Black, modifier = Modifier.size(250.dp)) // Reduced size to 250dp
                }
                Text(text = "Tablero", fontSize = 40.sp) // Reduced font size to 40sp
            }

            // Juegos column
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .height(450.dp) // Reduced height to 450dp from 500dp
                        .width(450.dp) // Reduced width to 450dp from 500dp
                        .clip(shape = RoundedCornerShape(20.dp))
                        .background(color = Color(android.graphics.Color.parseColor("#F1B4BB")))
                        .clickable(onClick = {
                            navController.navigate("JuegosMenuScreen")
                        }),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Black, modifier = Modifier.size(250.dp)) // Reduced size to 250dp
                }
                Text(text = "Juegos", fontSize = 40.sp) // Reduced font size to 40sp
            }
        }

        // Logout button aligned to the bottom right
        Button(
            onClick = {
                navController.navigate("LoginPage") {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                }
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp)
        ) {
            Text("Logout", fontSize = 20.sp)
        }
    }
}
