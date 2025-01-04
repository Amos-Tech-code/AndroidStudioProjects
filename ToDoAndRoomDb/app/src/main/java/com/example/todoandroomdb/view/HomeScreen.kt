package com.example.todoandroomdb.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.todoandroomdb.R
import com.example.todoandroomdb.model.ToDo
import com.example.todoandroomdb.viewModel.ToDoViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: ToDoViewModel
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar()
        }

    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            EntryList(viewModel = viewModel)
            TodoList(viewModel = viewModel)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EntryList(
    viewModel: ToDoViewModel,
    modifier: Modifier = Modifier
) {
    val title by viewModel.title.collectAsState()
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        modifier = Modifier.padding(start = 8.dp)
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = { viewModel.onTitleChange(it) },
            label = { Text(text = "Title...")},
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    viewModel.addToDo(title)
                    keyboardController?.hide()
                }
            )
        )
        Button(
            modifier = Modifier.padding(top = 8.dp),
            onClick = {
                viewModel.addToDo(title)
            }
        ) {
            Text(text = "Add")
        }
    }
}

@Composable
fun TodoList(viewModel: ToDoViewModel) {

    val toDoList = viewModel.toDoList.collectAsState(initial = emptyList())

    LazyColumn {
        items(toDoList.value) { toDoItem ->
            ToDoCard(toDoItem = toDoItem, viewModel)
        }
    }
}

@Composable
fun ToDoCard(
    toDoItem: ToDo,
    viewModel: ToDoViewModel
) {
    val openDialog = remember {
        mutableStateOf(false)
    }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = { Text(text = "Confirm Deletion") },
            text = { Text(text = "Are you sure you want to delete this task?") },
            confirmButton = {
                Button(onClick = {
                    viewModel.deleteToDo(toDoItem.id)
                    openDialog.value = false
                }) {
                    Text(text = "Ok")
                }
            },
            dismissButton = {
                Button(onClick = { openDialog.value = false }) {
                    Text(text = "Cancel")
                }
            }
        )
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Created At: ${toDoItem.createdAt}")

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = toDoItem.title, modifier = Modifier.weight(1f))
                IconButton( onClick = { openDialog.value = true }) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(R.string.app_name))
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}