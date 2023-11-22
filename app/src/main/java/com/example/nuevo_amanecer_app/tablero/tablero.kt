package com.example.nuevo_amanecer_app.tablero

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Matrix
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nuevo_amanecer_app.R
import com.example.nuevo_amanecer_app.paginas.juegos.FunBox
import java.util.Locale
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.ui.zIndex
import androidx.navigation.NavController

data class Imagen(val direccion: Int, val descripcion: String)
data class Matriz(val nombre: String, val imagenes: List<Imagen>)

class MatrizViewModel : ViewModel(){

    private val _matrices = mutableStateListOf<Matriz>()

    val matrices : List<Matriz> get() = _matrices

    fun addMatrix(newMatrix: Matriz){
        _matrices.add(newMatrix)
    }
}

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
            .size(150.dp)
            .clickable {
                textToSpeech(context, description)
            }

    )
}

@OptIn(ExperimentalLayoutApi::class)
@Preview(showBackground = true,device = "id:Nexus 10")
@Composable
fun Tablero(navController: NavController, matrixViewModel: MatrizViewModel = viewModel()){

    println(matrixViewModel.matrices)

    val imagenes = remember {
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

    val matrices = matrixViewModel.matrices
    var matrizSeleccionada by remember { mutableStateOf<Matriz?>(null) }



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {


                Button(
                    modifier = Modifier.padding(20.dp),
                    colors = ButtonDefaults.buttonColors( containerColor = Color(android.graphics.Color.parseColor("#D9D9D9")) ),
                    onClick = {
                        navController.navigate("HomeScreen")
                    }
                ) {
                    Text(text = "Regresar", fontSize = 40.sp, color = Color.Black)
                }

                Row(
                    modifier = Modifier.padding(start = 100.dp),
                ) {
                    
                    Text(text = "Nombre de tablero", fontSize = 50.sp,
                        color = Color.White)
                    
                    Text(
                        text = matrizSeleccionada?.nombre ?: "Select a Matrix",
                        fontSize = 50.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 100.dp)
                            .clickable {
                                // Show the dropdown menu when clicked
                                matrizSeleccionada = null
                            }
                    )


                }
            }

        Column(
            modifier = Modifier.padding(top = 50.dp)
        ) {

            FlowRow(
                modifier = Modifier
                    .background(Color.White)
                    .padding(start = 40.dp, end = 40.dp, top = 0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                maxItemsInEachRow = 3

            ) {

                imagenes.forEach { imagen: Imagen ->
                    drawImagen(
                        picture = remember { imagen.direccion },
                        description = imagen.descripcion
                    )
                }
            }
        }
    }
}
