package com.vincebiins.infrastructure.network

enum class ResponseCode(val code: Int, val message: String) {
    SUCCESS(200, "Success"),
    ERROR(400, "An error occurred"),
    SERVER_ERROR(500, "Internal server error"),
    BAD_REQUEST(400, "Bad request")
}