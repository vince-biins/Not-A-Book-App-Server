package com.vincebiins.infrastructure.network

import kotlinx.serialization.Serializable

@Serializable
sealed class Result<out T> {
    @Serializable
    data class Success<out T>(val code: ResponseCode, val message: String, val data: T) : Result<T>()
    @Serializable
    data class Error(val code: ResponseCode, val message: String) : Result<Nothing>()
}