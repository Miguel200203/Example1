package com.rick.workclass.ejemplo.com.example.example1.data.model.DataBase

import android.content.Context
import androidx.room.Room

object DatabaseProvider {
    private var instance: AppDataBase? = null

    fun getDatabase(context: Context): AppDataBase{
        return instance ?: synchronized(this){
            val db = Room.databaseBuilder(
                context.applicationContext,
                //if database does not exist, it will be created with the name
                //shown above between quotation marks
                AppDataBase::class.java, "app-db"
            ).build()
            instance = db
            db
        }
    }
}