package com.example.nuevo_amanecer_app.paginas.juegos

import android.content.Context
import android.speech.tts.TextToSpeech
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.nuevo_amanecer_app.R
import com.example.nuevo_amanecer_app.SaveState
import com.example.nuevo_amanecer_app.tablero.Imagen
import com.example.nuevo_amanecer_app.tablero.drawImagen
import com.example.room__compose.viewModel.vm
import org.w3c.dom.Text
import java.util.Locale




@Composable
fun FunBox(numero:MutableState<Int>,counter:MutableState<Int>,perder:MutableState<Int>){
    val colores    = listOf(
        Color.Red, Color.Blue, Color.Cyan, Color.Magenta,Color.Green,Color.Yellow,Color(0xFF008000),Color(0xFF967375),
        Color(0xFFFF748C),Color(0xFF84bFF3))
    //#0xFFFF748C
    if (numero.value==-1){
        Box(
            modifier= Modifier
                .size(150.dp)
                .background(Color.White)
                .clickable { if (perder.value==1){counter.value = -1} }
                .padding(start = 20.dp)
        )

        {

            Text(
                text = "",
                modifier = Modifier.padding(25.dp),
                style = TextStyle(fontSize = 45.sp)// Use TextStyle to set the font size
            )
        }
    }
    else if(numero.value==0){
        val randomInt = (0..5).random()
        Box(
            modifier= Modifier
                .size(150.dp)
                .background(colores.getOrNull(randomInt) ?: Color.Gray)
                .clickable {
                    counter.value = counter.value + 1
                    numero.value = -1
                }
                .padding(start = 20.dp)
        )
    }
    else {
            Box(
                modifier= Modifier
                    .size(150.dp)
                    .background(colores.getOrNull(numero.value) ?: Color.Gray)
                    .clickable {

                        if (numero.value == counter.value + 1) {
                            numero.value = -1
                            counter.value = counter.value + 1
                        } else if (perder.value==1) {
                            counter.value = -1
                        }
                    }
                    .padding(start = 20.dp)
            )
            {
                Text(
                    text = " ${numero.value}",
                    modifier = Modifier.padding(20.dp),
                    style = TextStyle(fontSize = 45.sp) // Use TextStyle to set the font size
                )


            }
        }

    }




@OptIn(ExperimentalLayoutApi::class)
@Composable
//@Preview(showBackground = true,device = "id:Nexus 10")
fun Nivel3y4(nivel : Int, navController: NavController,vM: vm) {
    var counter = remember {mutableStateOf(0)}

    var perder= remember { mutableStateOf(-1) }

    var numberList:MutableList<Int>
    /*var numberList: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1,-1,-1,-1,-1,
    -1,-1,-1,-1,-1,-1,-1,-1)*/
    //numberList.shuffle()
    if (nivel==4) {
        numberList = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1,-1,-1,-1,-1,
            -1,-1,-1,-1,-1,-1,-1,-1)
        numberList.shuffle()
    }
    else{
        numberList = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1,-1,-1,-1,-1,
            -1,-1,-1,-1,-1,-1,-1,-1)
        numberList.shuffle()
    }

    Button(
        modifier = Modifier.padding(20.dp),
        colors = ButtonDefaults.buttonColors( containerColor = Color(android.graphics.Color.parseColor("#D9D9D9")) ),
        onClick = {
            navController.navigate("JuegosMenuScreen")
        },
    ) {
        Icon(Icons.Default.ArrowBack, contentDescription = "asd", tint = Color.Black)
    }



    Row(
        modifier = Modifier
            .offset(x = 350.dp, y = 30.dp)
            .padding(bottom = 100.dp),
    )
    {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if(nivel == 3){
                Text(text = "Cuadricula de colores", fontSize = 60.sp)
            }
            else if(nivel == 4){
                Text(text = "Cuadricula de numeros", fontSize = 60.sp)
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Button(
                    modifier = Modifier
                        .size(80.dp),
                    onClick = { counter.value = -2 },
                    colors = ButtonDefaults.buttonColors( containerColor = Color(android.graphics.Color.parseColor("#D9D9D9")) ),
                    )
                {
                    Icon(
                        Icons.Default.Refresh,
                        contentDescription = "asd",
                        tint = Color.Black,
                        modifier = Modifier.size(30.dp) // Ajusta el tamaño aquí
                    )
                }

                Button(
                    modifier = Modifier
                        .size(80.dp),
                    onClick = { perder.value *= -1 },
                    colors = ButtonDefaults.buttonColors( containerColor = Color(android.graphics.Color.parseColor("#D9D9D9")) ),
                )
                {
                    Icon(
                        Icons.Default.Star,
                        contentDescription = "asd",
                        tint = Color.Black,
                        modifier = Modifier.size(30.dp) // Ajusta el tamaño aquí
                    )
                }

                if (counter.value != 9){
                Text(
                    modifier = Modifier.padding(20.dp),
                    text = "Contador: ${counter.value}",
                    style = TextStyle(fontSize = 40.sp)
                )
                }
                else{
                    counter.value=-7
                    Text(
                        modifier = Modifier.padding(20.dp),
                        text = "GANASTE!",
                        style = TextStyle(fontSize = 40.sp)
                    )
                    if (nivel==3){
                    vM.updateCuenta(
                        SaveState(
                            vM.id_set.value,
                            vM.nombre_set.value,
                            vM.juego1_set.value,
                            vM.juego2_set.value,
                            vM.juego3_set.value + 1,
                            vM.juego4_set.value
                        )
                    )
                    }
                    else{
                        vM.updateCuenta(
                            SaveState(
                                vM.id_set.value,
                                vM.nombre_set.value,
                                vM.juego1_set.value,
                                vM.juego2_set.value,
                                vM.juego3_set.value ,
                                vM.juego4_set.value+1
                            )
                        )

                    }

                }

                if (perder.value==-1) {
                    Text(
                        modifier = Modifier.padding(20.dp),
                        text = "sin perder",
                        style = TextStyle(fontSize = 40.sp)
                    )
                }
                else{
                    Text(
                        modifier = Modifier.padding(20.dp),
                        text = "se puede perder!",
                        style = TextStyle(fontSize = 40.sp)
                    )
                }

            }
        }


    }

    Column {
         FlowRow(modifier=Modifier.offset(x=40.dp,y=250.dp)){
             numberList.forEach{number->
                FunBox(numero = remember {mutableStateOf(number)}, counter,perder)
             }
         }
        //flow layout

    }


    if (counter.value==-2){
        if (nivel==3){
            navController.navigate("Nivel3")}

        else{
            navController.navigate("Nivel4")
        }
    }
}