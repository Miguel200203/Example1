package com.rick.workclass.ejemplo.com.example.example1.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rick.workclass.ejemplo.com.example.example1.data.model.AccountEntity

@Dao
interface AccountDao {
    @Query("SELECT*FROM AccountEntity")
    fun getAll(): List<AccountEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(account: AccountEntity)
    @Delete
    fun delete(account: AccountEntity)

}
