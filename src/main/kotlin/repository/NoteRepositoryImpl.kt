package com.vincebiins.repository

import com.vincebiins.model.CreateNote
import com.vincebiins.model.Note
import java.time.LocalDateTime

class NoteRepositoryImpl : NoteRepository {
    private val noteLists = mutableListOf(
        Note(
            id = 1,
            title = "First Note",
            body = "This is my first note",
            timeStamp = LocalDateTime.now().toString(),
            isPinned = true,
        ),
        Note(
            id = 2,
            title = "Second Note",
            body = "This is my second note",
            timeStamp = LocalDateTime.now().toString(),
            isPinned = false,
        ),
        Note(
            id = 3,
            title = "Third Note",
            body = "This is my third note",
            timeStamp = LocalDateTime.now().toString(),
            isPinned = true,
        )
    )

    override fun getAllNotes(): List<Note> {
        return noteLists.toList()
    }

    override fun getNoteById(id: Int): Note? {
        return noteLists.firstOrNull { it.id == id }
    }

    override fun addNewNote(note: CreateNote): Boolean {
        return noteLists.add(
            Note(
                id = noteLists.size + 1,
                title = note.title,
                body = note.body,
                timeStamp = LocalDateTime.now().toString(),
                isPinned = note.isPinned,
            )
        )
    }

    override fun deleteNote(id: Int): Boolean {
        return noteLists.removeIf { it.id == id }
    }
}