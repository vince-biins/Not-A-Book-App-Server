package com.vincebiins.controller

import com.vincebiins.core.network.ResponseCode
import com.vincebiins.core.network.Result
import com.vincebiins.model.CreateNote
import com.vincebiins.repository.NoteRepository
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


class NoteController(private val repository: NoteRepository) {

    fun Route.noteRoutes() {

        get("/notes") {
            val notes = repository.getAllNotes()
            call.respond(
                HttpStatusCode.OK,
                Result.Success(
                    code = ResponseCode.SUCCESS,
                    message = "Successfully fetched",
                    data = notes
                )
            )
        }

        get("/note/{id}") {
            val id = call.pathParameters["id"]?.toIntOrNull()

            if (id == null) {
                call.respond(
                    HttpStatusCode.BadRequest,
                    Result.Error(
                        code = ResponseCode.BAD_REQUEST,
                        message = "Error: Invalid ID"
                    )
                )
                return@get
            }

            val note = repository.getNoteById(id)
            if (note == null) {
                call.respond(
                    HttpStatusCode.NotFound,
                    Result.Error(
                        code = ResponseCode.ERROR,
                        message = "Note not found with ID: $id"
                    )
                )
            } else {
                call.respond(
                    HttpStatusCode.OK,
                    Result.Success(
                        code = ResponseCode.SUCCESS,
                        message = "Successfully fetched",
                        data = note
                    )
                )
            }

        }

        post("/note/add") {
            val note = call.receive<CreateNote>()

            if (repository.addNewNote(note)) {
                call.respond(
                    HttpStatusCode.Created,
                    Result.Success(
                        code = ResponseCode.SUCCESS,
                        message = "Note added successfully",
                        data = true,
                    )
                )
            } else {
                call.respond(
                    HttpStatusCode.InternalServerError,
                    Result.Error(
                        code = ResponseCode.SERVER_ERROR,
                        message = "Failed to add note"
                    )
                )

            }
        }

        delete("/note/delete/{id}") {
            val id = call.pathParameters["id"]?.toIntOrNull()
            if (id == null) {
                call.respond(
                    HttpStatusCode.BadRequest,
                    Result.Error(
                        code = ResponseCode.BAD_REQUEST,
                        message = "Error: Invalid ID"
                    )
                )
                return@delete
            }

            if (repository.deleteNote(id)) {
                call.respond(
                    HttpStatusCode.OK,
                    Result.Success(
                        code = ResponseCode.SUCCESS,
                        message = "Deleted successfully",
                        data = true
                    )
                )
            } else {
                call.respond(
                    HttpStatusCode.NotFound,
                    Result.Error(
                        code = ResponseCode.ERROR,
                        message = "Note not found with ID: $id"
                    )
                )
            }
        }
    }
}
