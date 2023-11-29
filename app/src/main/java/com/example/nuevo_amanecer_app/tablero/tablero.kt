package com.example.nuevo_amanecer_app.tablero

import android.content.Context
import android.speech.tts.TextToSpeech
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.Placeable.PlacementScope.Companion.coordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.nuevo_amanecer_app.R
import java.util.Locale
import androidx.navigation.NavController
import com.example.nuevo_amanecer_app.ViewModels.MatrizViewModel

data class Imagen(val direccion: Int, val descripcion: String)
data class Matriz(val nombre: String, val imagenes: List<Imagen>)


fun textToSpeech(context: Context, description: String){

    var textToSpeech: TextToSpeech? = null

    textToSpeech = TextToSpeech(context){

        if(it == TextToSpeech.SUCCESS){
            textToSpeech?.let{txtToSpeech ->
                val locSpanish = Locale("spa", "MEX")

                txtToSpeech.language = locSpanish
                txtToSpeech.setSpeechRate(1.0f)
                txtToSpeech.speak(
                    description,
                    TextToSpeech.QUEUE_ADD,
                    null,
                    null
                )
            }
        }
        else{

        }
    }
}

@Composable
fun drawImagen(picture: Int, description: String){

    val context = LocalContext.current

    Image(
        painter = painterResource(id = picture),
        contentDescription = description,
        modifier = Modifier
            .padding(start = 20.dp)
            .size(200.dp)
            .clip(shape = RoundedCornerShape(30.dp))
            .clickable {
                textToSpeech(context, description)
            }
    )
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Tablero(navController: NavController, matricesViewModel: MatrizViewModel){


    var matrizSeleccionada by remember { mutableStateOf<Matriz?>(null) }

    var selectedOption by remember { mutableStateOf<Matriz?>(null) }


    Column {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {


                Button(
                    colors = ButtonDefaults.buttonColors( containerColor = Color(android.graphics.Color.parseColor("#D9D9D9")) ),
                    onClick = {
                        navController.navigate("HomeScreen")
                    }
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "asd", tint = Color.Black)
                }


                Row(
                    //start = 300.dp, top = 15.dp
                    modifier = Modifier.padding(),
                ) {

                    var expanded by remember { mutableStateOf(false) }
                    val suggestions = matricesViewModel.matrices

                    var textfiledSize by remember { mutableStateOf(Size.Zero) }

                    val icon = if (expanded)
                        Icons.Filled.KeyboardArrowUp
                    else
                        Icons.Filled.KeyboardArrowDown

                    Column(
                    ) {

                        OutlinedTextField(
                            value = selectedOption?.nombre ?: "",
                            onValueChange = { input ->
                                selectedOption = matricesViewModel.matrices.firstOrNull { it.nombre == input }
                            },
                            modifier = Modifier
                                .width(500.dp)
                                .onGloballyPositioned { coordinates ->
                                    textfiledSize = coordinates.size.toSize()
                                }
                                .background(Color.White),
                            label = { Text(text = "Selecciona una matriz") },
                            trailingIcon = {
                                Icon(icon, "contentDescription",
                                    Modifier.clickable { expanded = !expanded })
                            }
                        )

                        /*
                        OutlinedTextField(
                            value = selectedOption,
                            onValueChange = { selectedOption = it},
                            modifier = Modifier
                                .fillMaxWidth()
                                .onGloballyPositioned { coordinates ->
                                    textfiledSize = coordinates.size.toSize()
                                }
                                .background(Color.White),
                            label = { Text(text = "Selecciona un matriz")},
                            trailingIcon = {
                                Icon(icon,"contentDescription", Modifier.clickable { expanded = !expanded })
                            }
                        )
                        */

                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false},
                            modifier = Modifier
                                .width(with(LocalDensity.current){textfiledSize.width.toDp()})
                        ) {
                            suggestions.forEach{ matriz ->
                                DropdownMenuItem(
                                    text = { Text(text = matriz.nombre)},
                                    onClick = {
                                        selectedOption = matriz
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }


                }

                Icon( painter = painterResource(id = R.drawable.sound), contentDescription = "sounf", modifier = Modifier.padding(start = 20.dp,end = 0.dp, top = 0.dp, bottom = 0.dp) )

            }

        Column(
            modifier = Modifier
                .padding(start = 250.dp)
                .clip(shape = RoundedCornerShape(30.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            FlowRow(
                modifier = Modifier
                    .background(Color.White)
                    .padding(start = 40.dp, end = 40.dp, top = 0.dp),
                horizontalArrangement = Arrangement.Center,
                verticalArrangement = Arrangement.Center,
                maxItemsInEachRow = 3

            ) {

                selectedOption?.imagenes?.forEach { imagen: Imagen ->
                    drawImagen(
                        picture = remember { imagen.direccion },
                        description = imagen.descripcion
                    )
                }

            }
        }
    }

}
