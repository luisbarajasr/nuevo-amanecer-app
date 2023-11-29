package com.example.nuevo_amanecer_app.paginas.juegos
import android.content.Context
import android.media.MediaPlayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TTS(navController: NavController) {

    val context = LocalContext.current
    //3X3

    Button(
        modifier = Modifier.padding(20.dp),
        colors = ButtonDefaults.buttonColors( containerColor = Color(android.graphics.Color.parseColor("#D9D9D9")) ),
        onClick = {
            navController.navigate("JuegosMenuScreen")
        },
    ) {
        Icon(Icons.Default.ArrowBack, contentDescription = "asd", tint = androidx.compose.ui.graphics.Color.Black)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 4.dp), // Add vertical padding to create space from top and bottom
        verticalArrangement = Arrangement.SpaceBetween, // Evenly distribute space
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sonidos",
            style = TextStyle(fontSize = 48.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.weight(1f))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { processAudio(context, "gallo" ) },
                    modifier = Modifier
                        .size(225.dp)
                        .padding(4.dp),
                    shape = RoundedCornerShape(4.dp),
                ) {
                    Box(
                        modifier = with (Modifier){
                            fillMaxSize()
                                .paint(
                                    // Replace with your image id
                                    painterResource(id = com.example.nuevo_amanecer_app.R.drawable.gallo_audio),
                                    contentScale = ContentScale.Fit,
                                    alignment = Alignment.Center )

                        })
                    {

                    }
                }

                Button(
                    onClick = { processAudio(context, "perro" ) },
                    modifier = Modifier
                        .size(225.dp)
                        .padding(4.dp),
                    shape = RoundedCornerShape(4.dp),
                ) {
                    Box(
                        modifier = with (Modifier){
                            fillMaxSize()
                                .paint(
                                    // Replace with your image id
                                    painterResource(id = com.example.nuevo_amanecer_app.R.drawable.perro_audio),
                                    contentScale = ContentScale.Fit,
                                    alignment = Alignment.Center )

                        })
                    {

                    }
                }

                Button(
                    onClick = { processAudio(context, "gato" ) },
                    modifier = Modifier
                        .size(225.dp)
                        .padding(4.dp),
                    shape = RoundedCornerShape(4.dp),
                ) {
                    Box(
                        modifier = with (Modifier){
                            fillMaxSize()
                                .paint(
                                    // Replace with your image id
                                    painterResource(id = com.example.nuevo_amanecer_app.R.drawable.gato_audio),
                                    contentScale = ContentScale.Fit,
                                    alignment = Alignment.Center )

                        })
                    {

                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { processAudio(context, "leon" ) },
                    modifier = Modifier
                        .size(225.dp)
                        .padding(4.dp),
                    shape = RoundedCornerShape(4.dp),
                ) {
                    Box(
                        modifier = with (Modifier){
                            fillMaxSize()
                                .paint(
                                    // Replace with your image id
                                    painterResource(id = com.example.nuevo_amanecer_app.R.drawable.leon_audio),
                                    contentScale = ContentScale.Fit,
                                    alignment = Alignment.Center )

                        })
                    {

                    }
                }
                Button(
                    onClick = { processAudio(context, "tren" ) },
                    modifier = Modifier
                        .size(225.dp)
                        .padding(4.dp),
                    shape = RoundedCornerShape(4.dp),
                ) {
                    Box(
                        modifier = with (Modifier){
                            fillMaxSize()
                                .paint(
                                    // Replace with your image id
                                    painterResource(id = com.example.nuevo_amanecer_app.R.drawable.tren_audio),
                                    contentScale = ContentScale.Fit,
                                    alignment = Alignment.Center )

                        })
                    {

                    }
                }
                Button(
                    onClick = { processAudio(context, "trompeta" ) },
                    modifier = Modifier
                        .size(225.dp)
                        .padding(4.dp),
                    shape = RoundedCornerShape(4.dp),
                ) {
                    Box(
                        modifier = with (Modifier){
                            fillMaxSize()
                                .paint(
                                    // Replace with your image id
                                    painterResource(id = com.example.nuevo_amanecer_app.R.drawable.trompeta_audio),
                                    contentScale = ContentScale.Fit,
                                    alignment = Alignment.Center )

                        })
                    {

                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { processAudio(context, "avion" ) },
                    modifier = Modifier
                        .size(225.dp)
                        .padding(4.dp),
                    shape = RoundedCornerShape(4.dp),
                ) {
                    Box(
                        modifier = with (Modifier){
                            fillMaxSize()
                                .paint(
                                    // Replace with your image id
                                    painterResource(id = com.example.nuevo_amanecer_app.R.drawable.avion),
                                    contentScale = ContentScale.Fit,
                                    alignment = Alignment.Center )

                        })
                    {

                    }
                }

                Button(
                    onClick = { processAudio(context, "carro" ) },
                    modifier = Modifier
                        .size(225.dp)
                        .padding(4.dp),
                    shape = RoundedCornerShape(4.dp),
                ) {
                    Box(
                        modifier = with (Modifier){
                            fillMaxSize()
                                .paint(
                                    // Replace with your image id
                                    painterResource(id = com.example.nuevo_amanecer_app.R.drawable.carro),
                                    contentScale = ContentScale.Fit,
                                    alignment = Alignment.Center )

                        })
                    {

                    }
                }

                Button(
                    onClick = { processAudio(context, "guitar" ) },
                    modifier = Modifier
                        .size(225.dp)
                        .padding(4.dp),
                    shape = RoundedCornerShape(4.dp),
                ) {
                    Box(
                        modifier = with (Modifier){
                            fillMaxSize()
                                .paint(
                                    // Replace with your image id
                                    painterResource(id = com.example.nuevo_amanecer_app.R.drawable.guitarra_audio),
                                    contentScale = ContentScale.Fit,
                                    alignment = Alignment.Center )

                        })
                    {

                    }
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))
    }

}


fun processAudio(context: Context, word: String) {
    val mediaPlayer = MediaPlayer.create(context, getAudioResourceId(context, word))
    mediaPlayer.start()
    mediaPlayer.setOnCompletionListener { mediaPlayer.release() }
}

private fun getAudioResourceId(context: Context, word: String): Int {
    return context.resources.getIdentifier("${word}_audio", "raw", context.packageName)
}

