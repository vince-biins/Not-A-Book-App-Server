package com.vincebiins.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Note(
    val id: Int?,
    val title: String,
    val body: String,
    val timeStamp: String?,
    val isPinned: Boolean,
)

