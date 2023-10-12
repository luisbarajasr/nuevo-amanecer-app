package com.example.nuevo_amanecer_app.paginas.juegos

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FunBox(numero:MutableState<Int>){
    val colores = listOf(Color.Red, Color.Blue, Color.Cyan, Color.Magenta,Color.Green,Color.Yellow)
    if (numero.value==-1){
        Box(
            modifier= Modifier
                .size(150.dp)
                .background(Color.DarkGray)
        )

        {
            Text(
                text = "-1",
                modifier = Modifier.padding(25.dp),
                style = TextStyle(fontSize = 45.sp) // Use TextStyle to set the font size
            )
        }
    }
    else if(numero.value==0){
        val randomInt = (0..5).random()
        Box(
            modifier= Modifier
                .size(150.dp)
                .background(colores.getOrNull(randomInt) ?: Color.Gray)
                .clickable{
                    if (numero.value!=-1){
                        numero.value=-1
                    }
                }
        )
    }
    else {
            Box(
                modifier= Modifier
                    .size(150.dp)
                    .background(colores.getOrNull(numero.value) ?: Color.Gray)
                    .clickable{
                        if (numero.value!=-1){
                            numero.value=-1
                        }
                    }
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




@Preview(showBackground = true,device = "id:Nexus 10")
@Composable
fun Nivel3y4(nivel : Int=3) {

    Surface(modifier=Modifier.fillMaxSize()) {
        Text(text="NIVEL $nivel",modifier=Modifier.offset(x=450.dp,y=80.dp),
                style = TextStyle(fontSize = 120.sp))



        Row(modifier=Modifier.offset(x=0.dp,y=350.dp),
            horizontalArrangement = spacedBy(0.dp)) {

            FunBox(numero =remember{mutableStateOf(4)})

            FunBox(numero =remember{mutableStateOf(2)})
            FunBox(numero =remember{mutableStateOf(0)})
            FunBox(numero =remember{mutableStateOf(-1)})


        }
    }
}