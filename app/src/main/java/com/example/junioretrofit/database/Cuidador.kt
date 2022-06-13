package com.example.junioretrofit.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cuidadores_table")
data class Cuidador(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val mascota:String,
    val fecha:String,
    val localidad:String,
    val cuidador:String
)