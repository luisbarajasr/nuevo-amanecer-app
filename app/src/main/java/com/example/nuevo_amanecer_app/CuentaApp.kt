package com.example.nuevo_amanecer_app

import android.app.Application
import androidx.room.Room

class CuentaApp: Application() {

    val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            DB::class.java,
            "DB_db"
        ).build()
    }
}