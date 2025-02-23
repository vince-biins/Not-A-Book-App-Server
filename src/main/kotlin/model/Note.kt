package com.vincebiins.model

import kotlinx.serialization.Serializable

@Serializable
data class Note(
    val id: Int?,
    val title: String,
    val body: String,
    val timeStamp: String?,
    val isPinned: Boolean,
)

@Serializable
data class CreateNote(
    val title: String,
    val body: String,
    val isPinned: Boolean,
)
