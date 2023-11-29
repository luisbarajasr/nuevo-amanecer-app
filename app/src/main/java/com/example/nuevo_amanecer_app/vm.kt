package com.example.room__compose.viewModel

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope


import com.example.nuevo_amanecer_app.CuentaApp
import com.example.nuevo_amanecer_app.SaveState


import kotlinx.coroutines.launch


class vm(application: Application) : ViewModel() {

    val cuentas = mutableStateOf<List<SaveState>>(emptyList())

    private val database = (application as CuentaApp).database
    private val dao = database.dao

    var id_set= mutableStateOf<Int>(-1)
    var nombre_set= mutableStateOf<String>("")
    var juego1_set= mutableStateOf<Int>(-1)
    var juego2_set= mutableStateOf<Int>(-1)
    var juego3_set= mutableStateOf<Int>(-1)
    var juego4_set= mutableStateOf<Int>(-1)

    //var producto_set = remember{mutableStateOf("nothing")}
    //var precio_set= remember{mutableStateOf(-1.0)}

    init {

        viewModelScope.launch {
            dao.getAllCuentas().collect(){
                cuentas.value=it

        }
    }
    }

    fun createCuenta(name: String, juego1: Int,juego2:Int,juego3:Int,juego4:Int){
        val product = SaveState(0,name,juego1,juego2,juego3,juego4)
        viewModelScope.launch {
            dao.insertCuenta(product)
        }
    }

    // PROGRESS SAVER

    fun updateCuenta(cuenta: SaveState){
        viewModelScope.launch {
            dao.updateCuenta(cuenta)
        }
    }

    fun deleteCuenta(cuenta: SaveState){
        viewModelScope.launch {
            dao.deleteCuenta(cuenta)
        }
    }

}