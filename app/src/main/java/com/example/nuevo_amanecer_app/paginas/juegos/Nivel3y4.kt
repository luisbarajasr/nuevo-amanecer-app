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
import androidx.compose.material3.Button
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
fun Perder(){
    Text(text="HAS PERDIDO :(",style = TextStyle(fontSize = 600.sp))
}







@Composable
fun FunBox(numero:MutableState<Int>,counter:MutableState<Int>){
    val colores = listOf(Color.Red, Color.Blue, Color.Cyan, Color.Magenta,Color.Green,Color.Yellow)
    if (numero.value==-1){
        Box(
            modifier= Modifier
                .size(150.dp)
                .background(Color.DarkGray)
                .clickable{counter.value=-1}
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
                .clickable {
                    counter.value=counter.value+1
                    numero.value=-1
                }
        )
    }
    else {
            Box(
                modifier= Modifier
                    .size(150.dp)
                    .background(colores.getOrNull(numero.value) ?: Color.Gray)
                    .clickable {

                            if (numero.value == counter.value+1) {
                                numero.value = -1
                                counter.value = counter.value + 1
                            }
                            else {
                                counter.value=-1
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
    var counter = remember {mutableStateOf(0)}

    Surface(modifier=Modifier.fillMaxSize()) {
Row(modifier = Modifier.offset(x = 0.dp, y = 150.dp)) {
    Text(
        text = "C${counter.value}",
        style = TextStyle(fontSize = 60.sp)
    )
    Button(
        modifier = Modifier.size(100.dp),
        onClick = { counter.value = -2 }) { Text(text = "resetear") }
}
        Column(modifier = Modifier.offset(x = 0.dp, y = 283.dp),) {
            Row(

            horizontalArrangement = spacedBy(0.dp)
            ) {

                FunBox(numero = remember { mutableStateOf(2) }, counter)
                FunBox(numero = remember { mutableStateOf(1) }, counter)
                FunBox(numero = remember { mutableStateOf(3) }, counter)
                FunBox(numero = remember { mutableStateOf(-1) }, counter)
            }
            Row(
                horizontalArrangement = spacedBy(0.dp)){
                FunBox(numero = remember { mutableStateOf(4) }, counter)
                FunBox(numero = remember { mutableStateOf(6) }, counter)
                FunBox(numero = remember { mutableStateOf(5) }, counter)
                FunBox(numero = remember { mutableStateOf(-1) }, counter)



            }
            Row(
                horizontalArrangement = spacedBy(0.dp)){
                FunBox(numero = remember { mutableStateOf(0) }, counter)
                FunBox(numero = remember { mutableStateOf(0) }, counter)
                FunBox(numero = remember { mutableStateOf(0) }, counter)
                FunBox(numero = remember { mutableStateOf(0) }, counter)
            }

        }
    }
    if (counter.value==-2){
        Nivel3y4()
    }


}