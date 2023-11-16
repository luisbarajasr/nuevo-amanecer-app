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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nuevo_amanecer_app.R
import com.example.nuevo_amanecer_app.paginas.juegos.FunBox
import java.util.Locale

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
data class Imagen(val direccion: Int, val descripcion: String)
@Composable
fun drawImagen(picture: Int, description: String){

    val context = LocalContext.current

    Image(
        painter = painterResource(id = picture),
        contentDescription = description,
        modifier = Modifier
            .padding(start = 20.dp)
            .size(200.dp)
            .clickable {
                textToSpeech(context, description)
            }

    )
}

@OptIn(ExperimentalLayoutApi::class)
@Preview(showBackground = true,device = "id:Nexus 10")
@Composable
fun Tablero(){

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


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
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
                    Text(text = "Nombre de tablero", fontSize = 50.sp, color = Color.White)
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

                imagenes.forEach { imagen: Imagen ->
                    drawImagen(
                        picture = remember { imagen.direccion },
                        description = imagen.descripcion
                    )
                }
            }
        }



}
