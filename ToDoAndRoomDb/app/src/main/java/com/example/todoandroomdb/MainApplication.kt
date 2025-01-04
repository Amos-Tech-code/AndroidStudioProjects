package com.example.todoandroomdb

import android.app.Application
import androidx.room.Room
import com.example.todoandroomdb.model.db.ToDoDatabase

class MainApplication: Application() {

    companion object {
        lateinit var toDoDatabase: ToDoDatabase
    }

    override fun onCreate() {
        super.onCreate()
        toDoDatabase = Room.databaseBuilder(
            applicationContext,
            ToDoDatabase::class.java,
            ToDoDatabase.NAME
        ).fallbackToDestructiveMigration()
            .build()
    }
}