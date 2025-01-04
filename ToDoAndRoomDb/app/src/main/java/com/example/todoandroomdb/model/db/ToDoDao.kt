package com.example.todoandroomdb.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todoandroomdb.model.ToDo
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Query("SELECT * FROM ToDo")
    fun getAllToDo(): Flow<List<ToDo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertToDo(toDo: ToDo)

    @Query("DELETE FROM ToDo WHERE id = :id")
    suspend fun deleteToDo(id: Int)
}