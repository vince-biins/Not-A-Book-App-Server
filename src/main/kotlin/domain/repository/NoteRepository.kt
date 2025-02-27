package com.vincebiins.domain.repository

import com.vincebiins.domain.model.Note

interface NoteRepository {
    fun getAllNotes() : List<Note>
    fun getNoteById(id : Int) : Note?
    fun addNewNote(note : Note) : Boolean
    fun deleteNote(id : Int) : Boolean
}