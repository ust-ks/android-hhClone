package ru.example.mobile.data.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface AbstractDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: List<T>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: T)

    @Update
    fun update(data: List<T>)

    @Update
    fun update(data: T)

    @Delete
    fun delete(data: T)

    @Delete
    fun delete(data: List<T>)
}