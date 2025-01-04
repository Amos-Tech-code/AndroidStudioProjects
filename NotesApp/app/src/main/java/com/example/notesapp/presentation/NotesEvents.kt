package com.example.notesapp.presentation

import com.example.notesapp.data.Note

sealed interface NotesEvents {

    data object SortNotes: NotesEvents

    data class DeleteNotes(val note: Note): NotesEvents

    data class SaveNotes(
        val title: String,
        val description: String
    ): NotesEvents
}