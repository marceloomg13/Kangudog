package com.example.junioretrofit.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CuidadorDao {

    @Query("SELECT * FROM cuidadores_table")
    fun readAllData(): LiveData<List<Cuidador>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(cuidador:Cuidador)

    @Delete
    suspend fun delete(cuidador: Cuidador)
}