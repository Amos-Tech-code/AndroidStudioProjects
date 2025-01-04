package com.example.notesapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Sort
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.notesapp.R

@Composable
fun NotesScreen(
    state: NotesState,
    navController: NavController,
    onEvents: (NotesEvents) -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(onEvents)
        },
        
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    state.title.value = ""
                    state.description.value = ""
                    navController.navigate("AddNotesScreen")
                }
            ) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = "Add New Notes")
            }
        }
    ) { paddingValues ->

        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            items(state.notes.size) { index ->
                NotesItem(
                    onEvents = onEvents,
                    state = state,
                    index = index
                )
            }
        }
    }
}


@Composable
fun NotesItem(
    onEvents: (NotesEvents) -> Unit,
    state: NotesState,
    index: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(12.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = state.notes[index].title,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = state.notes[index].description,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
        
        IconButton(
            onClick = { onEvents(NotesEvents.DeleteNotes(state.notes[index])) }
        ) {
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = "Delete Notes",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(35.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onEvents: (NotesEvents) -> Unit
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        title = { Text(text = stringResource(R.string.app_name)) },
        actions = {
            IconButton(onClick = { onEvents(NotesEvents.SortNotes) }) {
                Icon(
                    imageVector = Icons.Rounded.Sort,
                    contentDescription = "Sort Notes",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(35.dp)
                )
            }
        }
    )
}