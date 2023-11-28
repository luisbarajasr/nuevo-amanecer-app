package com.example.nuevo_amanecer_app.ViewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.nuevo_amanecer_app.tablero.Matriz

class MatrizViewModel : ViewModel(){

    private val _matrices = mutableStateListOf<Matriz>()

    val matrices : List<Matriz> get() = _matrices

    fun addMatrix(newMatrix: Matriz){
        _matrices.add(newMatrix)
    }
}