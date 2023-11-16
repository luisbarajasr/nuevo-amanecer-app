package com.example.nuevo_amanecer_app.tablero

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.nuevo_amanecer_app.R

@Composable
fun drawImagenOp(picture: Int, description: String, onClick: () -> Unit){

    val context = LocalContext.current
    Box(
        modifier = Modifier
            .size(200.dp)
            .clickable { onClick() }
    ){
        Image(
            painter = painterResource(id = picture),
            contentDescription = description,
            modifier = Modifier.fillMaxSize()
        )
        Text(text = description)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun editarTablero(){

    val seleccionarImagenes = remember {
        listOf(
            Imagen(R.drawable.fiesta,"fiesta"),
            Imagen(R.drawable.abuelos,"abuelos"),
            Imagen(R.drawable.amigos,"amigos"),
            Imagen(R.drawable.basketball,"basketbol"),
            Imagen(R.drawable.comer,"comer"),
            Imagen(R.drawable.estudiar,"estudiar"),
            Imagen(R.drawable.navidad,"navidad"),
            Imagen(R.drawable.trabajo,"trabajo"),
            Imagen(R.drawable.futbol,"futbol"),
        )
    }

    val imagenesSeleccionadas = remember { mutableStateListOf<Imagen>() }

    Row {
        Column(
            modifier = Modifier.width(1000.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = Modifier
                    .padding(20.dp)
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(30.dp))
                    .background(Color.Gray)
            ){
                Row(
                    modifier = Modifier.padding(16.dp)

                ) {
                    Text(text = "Nuevo Tablero", fontSize = 50.sp, color = Color.White)
                }
            }
            FlowRow(
                modifier = Modifier
                    .background(Color.White)
                    .padding(start = 40.dp, end = 40.dp, top = 0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                maxItemsInEachRow = 3

            ) {

                imagenesSeleccionadas.forEach { imagen: Imagen ->
                    drawImagen(
                        picture = remember { imagen.direccion },
                        description = imagen.descripcion
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(20.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Text( text = "Selecciona las imagenes: ", fontSize = 20.sp, color = Color.Black)
            FlowRow(
                horizontalArrangement = Arrangement.Center,
                maxItemsInEachRow = 1
            ) {
                seleccionarImagenes.forEach{imagen ->
                    drawImagenOp(picture = remember { imagen.direccion }, description = imagen.descripcion) {
                        if(imagen !in imagenesSeleccionadas){
                            imagenesSeleccionadas.add(imagen)
                        }else{
                            imagenesSeleccionadas.remove(imagen)
                        }
                    }
                }
            }
        }
    }
}