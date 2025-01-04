package com.example.todoandroomdb.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todoandroomdb.model.ToDo


@Database(
    entities = [ToDo::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class ToDoDatabase: RoomDatabase() {
    companion object{
        const val NAME = "ToDo_DB"

    }

    abstract fun getToDoDao(): ToDoDao
}