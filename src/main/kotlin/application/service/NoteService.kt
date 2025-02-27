package com.vincebiins.application.service

import com.vincebiins.domain.model.Note
import com.vincebiins.presentation.dto.NoteDto

interface NoteService {
    fun getAllNotes() : List<NoteDto>
    fun getNoteById(id: Int) : NoteDto?
    fun createNote(note: NoteDto) : Boolean
    fun deleteNoteById(id: Int) : Boolean
}