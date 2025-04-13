package com.rick.workclass.ejemplo.com.example.example1.data.model.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rick.workclass.ejemplo.com.example.example1.data.dao.AccountDao
import com.rick.workclass.ejemplo.com.example.example1.data.model.AccountEntity

@Database(entities = [AccountEntity::class],version =1)
abstract class AppDataBase:RoomDatabase(){
    abstract fun AccountDao(): AccountDao
}