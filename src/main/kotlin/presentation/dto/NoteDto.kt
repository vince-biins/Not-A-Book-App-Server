package com.vincebiins.presentation.dto

import kotlinx.serialization.Serializable


@Serializable
data class NoteDto(
    val title: String,
    val body: String,
    val isPinned: Boolean,
    val timeStamp: String? = null,
)
