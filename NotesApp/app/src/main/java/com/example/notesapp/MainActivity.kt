package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.notesapp.data.NotesDatabase
import com.example.notesapp.presentation.AddNotesScreen
import com.example.notesapp.presentation.NotesScreen
import com.example.notesapp.presentation.NotesViewModel
import com.example.notesapp.ui.theme.NotesAppTheme

class MainActivity : ComponentActivity() {

    private val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            NotesDatabase::class.java,
            "notes_db"
        ).build()
    }

    private val viewModel by viewModels<NotesViewModel> (
        factoryProducer = {
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return NotesViewModel(database.noteDao) as T
                }
            }
        }
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotesAppTheme(darkTheme = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NotesApp(
                        modifier = Modifier.padding(innerPadding),
                        viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun NotesApp(
    modifier: Modifier = Modifier,
    viewModel: NotesViewModel
) {

    val state by viewModel.state.collectAsState()
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "NotesScreen"
    ) {
        composable("NotesScreen") {
            NotesScreen(
                state = state,
                navController = navController,
                onEvents = viewModel::onEvent
            )
        }

        composable("AddNotesScreen") {
            AddNotesScreen(
                state = state,
                navController = navController,
                onEvents = viewModel::onEvent
            )
        }
    }
}