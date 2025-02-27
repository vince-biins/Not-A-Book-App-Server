package com.vincebiins.application.mappers

import com.vincebiins.domain.model.Note
import com.vincebiins.presentation.dto.NoteDto
import java.time.LocalDateTime


fun Note.toNoteDto() = NoteDto(
    title = title,
    body = body,
    isPinned = isPinned,
    timeStamp = timeStamp,
)

fun NoteDto.toNote() = Note(
    id = null,
    title = title,
    body = body,
    isPinned = isPinned,
    timeStamp = LocalDateTime.now().toString(),
)