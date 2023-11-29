package com.example.nuevo_amanecer_app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class SaveState(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val nombre:String,
    val juego1:Int,
    val juego2:Int,
    val juego3: Int,
    val juego4:Int

)