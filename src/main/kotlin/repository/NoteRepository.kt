package com.vincebiins.repository

import com.vincebiins.model.CreateNote
import com.vincebiins.model.Note

interface NoteRepository {
    fun getAllNotes() : List<Note>
    fun getNoteById(id : Int) : Note?
    fun addNewNote(note : CreateNote) : Boolean
    fun deleteNote(id : Int) : Boolean
}