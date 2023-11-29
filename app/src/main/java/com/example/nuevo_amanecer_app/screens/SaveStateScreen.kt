package com.example.nuevo_amanecer_app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nuevo_amanecer_app.SaveState
import com.example.room__compose.viewModel.vm

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun SaveStateScreen(navController: NavController,appViewModel: vm) {

    val cuentaName = remember {
        mutableStateOf("")
    }

    val cuentaId = remember {
        mutableStateOf(0)
    }

    val cuentaJuego1 = remember {
        mutableStateOf(0)
    }

    val cuentaJuego2 = remember {
        mutableStateOf(0)
    }

    val cuentaJuego3 = remember {
        mutableStateOf(0)
    }

    val cuentaJuego4 = remember {
        mutableStateOf(0)
    }

    val actualizarEnabled = remember {
        mutableStateOf(false)
    }

    val agregarCuenta = remember {
        mutableStateOf(true)
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Mis Productos", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        Text(text=appViewModel.nombre_set.value)
        Text(text=appViewModel.juego1_set.value.toString())
        Text(text=appViewModel.juego2_set.value.toString())
        Text(text=appViewModel.juego3_set.value.toString())
        Text(text=appViewModel.juego4_set.value.toString())





        TextField(
            value = cuentaName.value,
            onValueChange = { cuentaName.value = it },
            placeholder = { Text(text = "Nombre de la cuenta ") }
        )

        TextField(
            value = cuentaJuego1.value.toString(),
            onValueChange = { cuentaJuego1.value = it.toInt() },
            placeholder = { Text(text = "Progreso de juego 1") }
        )

        TextField(
            value = cuentaJuego2.value.toString(),
            onValueChange = { cuentaJuego2.value = it.toInt() },
            placeholder = { Text(text = "Progreso de juego 2") }
        )

        TextField(
            value = cuentaJuego3.value.toString(),
            onValueChange = { cuentaJuego3.value = it.toInt() },
            placeholder = { Text(text = "Progreso de juego 3") }
        )

        TextField(
            value = cuentaJuego4.value.toString(),
            onValueChange = { cuentaJuego4.value = it.toInt() },
            placeholder = { Text(text = "Progreso de juego 4") }
        )


        Row {

            if (agregarCuenta.value) {
                Button(onClick = {

                    appViewModel.createCuenta(cuentaName.value, cuentaJuego1.value,cuentaJuego2.value,
                        cuentaJuego3.value,cuentaJuego4.value)

                }) {
                    Text(text = "AGREGAR CUENTA")
                }

            }
            if (actualizarEnabled.value) {
                Button(onClick = {
                    appViewModel.updateCuenta(
                        SaveState(
                            cuentaId.value,
                            cuentaName.value,
                            cuentaJuego1.value,
                            cuentaJuego2.value,
                            cuentaJuego3.value,
                            cuentaJuego4.value
                        )
                    )
                    actualizarEnabled.value = false
                    agregarCuenta.value = true

                }) {
                    Text(text = "Actualizar")
                }
                Button(onClick = {
                    actualizarEnabled.value = false
                    agregarCuenta.value = true
                }) {
                    Text(text = "Cancelar")
                }
            }
        }

        LazyColumn(modifier = Modifier.fillMaxWidth()) {

            items(appViewModel.cuentas.value) {
                CuentaItem(cuenta = it, modifier = Modifier.fillMaxWidth(),
                    onEdit = {
                        cuentaName.value = it.nombre
                        cuentaJuego1.value = it.juego1
                        cuentaJuego2.value = it.juego2
                        cuentaJuego3.value = it.juego3
                        cuentaJuego4.value = it.juego4
                        cuentaId.value = it.id
                        actualizarEnabled.value = true
                        agregarCuenta.value = false
                    },

                    onDelete = {
                        appViewModel.deleteCuenta(SaveState(it.id, "", 0,0,0,0))
                    },
                    onSet={
                        appViewModel.id_set.value=it.id
                        appViewModel.nombre_set.value=it.nombre
                        appViewModel.juego1_set.value=it.juego1
                        appViewModel.juego2_set.value=it.juego2
                        appViewModel.juego3_set.value=it.juego3
                        appViewModel.juego4_set.value=it.juego4

                    }
                )


            }

        }


    }
}

@Preview
@Composable
fun CuentaItem(
    cuenta: SaveState = SaveState(0, "", 0,0,0,0),
    onEdit: () -> Unit = {},
    onDelete: () -> Unit = {},
    onSet:()-> Unit={},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "${cuenta.nombre}  J1: ${cuenta.juego1} J2:${cuenta.juego2} J3:${cuenta.juego3} J4:${cuenta.juego4}")
        IconButton(onClick = onEdit) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
        }
        IconButton(onClick = onDelete) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
        }
        IconButton(onClick= onSet){
            Icon(imageVector = Icons.Default.Face, contentDescription = "Select product as main one")
        }
    }
}
