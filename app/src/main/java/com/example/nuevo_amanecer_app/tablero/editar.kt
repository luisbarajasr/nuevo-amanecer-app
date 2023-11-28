package com.example.nuevo_amanecer_app.tablero

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.example.nuevo_amanecer_app.R
import com.example.nuevo_amanecer_app.ViewModels.MatrizViewModel

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

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun editarTablero(navController: NavController, matricesViewModel: MatrizViewModel){

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

    // Local state to track the new matrix being created
    var newMatrixName by remember { mutableStateOf("") }
    val imagenesSeleccionadas = remember { mutableStateListOf<Imagen>() }

    Row {

        Column(
            modifier = Modifier.width(1000.dp),

        ) {

            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ){
                Button(
                    modifier = Modifier.padding(20.dp),
                    colors = ButtonDefaults.buttonColors( containerColor = Color(android.graphics.Color.parseColor("#D9D9D9")) ),
                    onClick = {
                        navController.navigate("HomeScreen")
                    }
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "asd", tint = Color.Black)
                }

                Row(
                    modifier = Modifier.padding(start = 100.dp) ,
                    ) {
                    Text(text = "Editando tablero", fontSize = 60.sp)
                }
            }

            Box(
                modifier = Modifier.padding(start = 200.dp, bottom = 40.dp, top = 30.dp),

            ){

                Column (
                    modifier = Modifier
                        .width(600.dp)
                        .height(450.dp)
                        .background(Color.White)
                ){

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
            
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                TextField(
                    value = newMatrixName,
                    onValueChange = { newMatrixName = it },
                    label = { Text("Nombre: ") },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                )

                Column {

                    Button(
                        modifier = Modifier
                            .width(200.dp)
                            .height(50.dp)
                            .padding(start = 20.dp),
                        colors = ButtonDefaults.buttonColors( containerColor = Color(android.graphics.Color.parseColor("#CDE7B0")) ),
                        onClick = {
                            val newMatriz = Matriz(newMatrixName, imagenesSeleccionadas.toList())
                            matricesViewModel.addMatrix(newMatriz)
                            navController.navigate("HomeScreen")
                        })
                    {
                        Text(text = "Guardar", color = Color.Black)
                    }
                }
            }

        }

        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text( text = "Selecciona las imagenes: ", fontSize = 20.sp, color = Color.Black)
            FlowRow(
                modifier = Modifier
                    .padding(top = 20.dp),
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