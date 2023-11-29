package com.example.nuevo_amanecer_app

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities=[SaveState::class], version=1)
abstract class DB : RoomDatabase(){
    abstract val dao:CuentaDao
}