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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.nuevo_amanecer_app.R
import com.example.nuevo_amanecer_app.ViewModels.MatrizViewModel

@Composable

fun HomeScreen(navController: NavController){
    Box{
        Button(
            modifier = Modifier.padding(20.dp),
            colors = ButtonDefaults.buttonColors( containerColor = Color(android.graphics.Color.parseColor("#D9D9D9")) ),
            onClick = {
                navController.navigate("MenuScreen")
            },
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "asd", tint = Color.Black)
        }
    }

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
                        .background(color = Color(android.graphics.Color.parseColor("#337CCF")))
                        .clickable(onClick = {
                            navController.navigate("tablero")
                        }),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(Icons.Default.ExitToApp, contentDescription = "vdjfg", tint = Color.Black, modifier = Modifier.size(300.dp))
                }
                Text(text = "Ir a tablero", fontSize = 50.sp)

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
                        .background(color = Color(android.graphics.Color.parseColor("#A8DF8E")))
                        .clickable(onClick = {
                            navController.navigate("editarTablero")
                        }),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(Icons.Default.Create, contentDescription = "vdjfg", tint = Color.Black, modifier = Modifier.size(300.dp))
                }
                Text(text = "Editar tablero", fontSize = 50.sp)

            }

        }
    }

}