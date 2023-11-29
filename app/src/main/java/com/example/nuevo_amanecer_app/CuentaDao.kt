package com.example.nuevo_amanecer_app

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CuentaDao {
    @Insert
    suspend fun insertCuenta(cuenta: SaveState)

    @Query("Select * from SaveState")
    fun getAllCuentas(): Flow<List<SaveState>>

    @Delete
    suspend fun deleteCuenta(cuenta: SaveState)

    @Update
    suspend fun updateCuenta(cuenta: SaveState)
}