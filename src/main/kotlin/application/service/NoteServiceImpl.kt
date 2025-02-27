package com.vincebiins.application.service

import com.vincebiins.application.mappers.toNote
import com.vincebiins.application.mappers.toNoteDto
import com.vincebiins.presentation.dto.NoteDto
import com.vincebiins.domain.repository.NoteRepository

class NoteServiceImpl(private val repository: NoteRepository) : NoteService {
    override fun getAllNotes(): List<NoteDto> {
        val notes = repository.getAllNotes()
        return notes.map { it.toNoteDto() }
    }

    override fun getNoteById(id: Int): NoteDto? {
        val note = repository.getNoteById(id = id)
        return note?.toNoteDto()
    }

    override fun deleteNoteById(id: Int): Boolean = repository.deleteNote(id)

    override fun createNote(note: NoteDto): Boolean = repository.addNewNote(note = note.toNote())
}