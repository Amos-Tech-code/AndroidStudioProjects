package com.example.todoandroomdb.viewModel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoandroomdb.MainApplication
import com.example.todoandroomdb.model.ToDo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class ToDoViewModel: ViewModel() {

    private val _title = MutableStateFlow("")
    val title = _title.asStateFlow()

    val toDoDao = MainApplication.toDoDatabase.getToDoDao()

    val toDoList: Flow<List<ToDo>> = toDoDao.getAllToDo()

    @RequiresApi(Build.VERSION_CODES.O)
    fun addToDo(title: String) {
        if (title.isNotEmpty()) {
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    Log.d("ToDoViewModel", "Attempting to insert ToDo: $title")
                    toDoDao.insertToDo(
                        ToDo(
                            title = title,
                            createdAt = Date.from(Instant.now())
                        )
                    )
                    Log.d("ToDoViewModel", "ToDo inserted successfully")
                    _title.value = ""
                } catch (e: Exception) {
                    Log.e("ToDoViewModel", "Error inserting ToDo", e)
                }
            }
        } else {
            Log.d("ToDoViewModel", "Title is empty")
        }
    }

    fun deleteToDo(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            toDoDao.deleteToDo(id)

        }
    }

    fun onTitleChange(newTitle: String) {
        _title.value = newTitle
    }

}