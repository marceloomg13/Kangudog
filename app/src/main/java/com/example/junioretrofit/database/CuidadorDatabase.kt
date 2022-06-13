package com.example.junioretrofit.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Cuidador::class], version = 1, exportSchema = false)
abstract class CuidadorDatabase:RoomDatabase() {

    abstract fun cuidadorDao(): CuidadorDao

    companion object{
        @Volatile
        private var INSTANCE: CuidadorDatabase? = null

    fun getDatabase(context: Context):CuidadorDatabase {
        val tempInstance = INSTANCE
        if (tempInstance != null) {
            return tempInstance
        }
        synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                CuidadorDatabase::class.java,
                "cuidadores_table"
            ).build()
            INSTANCE = instance
            return instance
        }
    }
    }
}