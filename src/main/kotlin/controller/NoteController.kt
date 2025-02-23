package com.vincebiins.routes

import com.vincebiins.model.CreateNote
import com.vincebiins.repository.NoteRepository
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


class NoteController(private val repository: NoteRepository) {

    fun Route.noteRoutes() {

        get("/notes") {
            call.respond(HttpStatusCode.OK, repository.getAllNotes())
        }

        get("/note/{id}") {
            val id = call.pathParameters["id"]?.toIntOrNull()

            if (id == null) {
                call.respond(HttpStatusCode.BadRequest, "Error: Invalid ID")
                return@get
            }

            val note = repository.getNoteById(id)
            if (note == null) {
                call.respond(HttpStatusCode.NotFound, "Note not found with ID: $id")
            } else {
                call.respond(HttpStatusCode.OK, note)
            }

        }

        post("/note/add") {
            val note = call.receive<CreateNote>()

            if (repository.addNewNote(note)) {
                call.respond(HttpStatusCode.Created, "Note added successfully")
            } else {
                call.respond(HttpStatusCode.InternalServerError, "Failed to add note")

            }
        }

        delete("/note/delete/{id}") {
            val id = call.pathParameters["id"]?.toIntOrNull()
            if (id == null) {
                call.respond(HttpStatusCode.BadRequest, "Error: Invalid ID")
                return@delete
            }

            if (repository.deleteNote(id)) {
                call.respond(HttpStatusCode.OK, "Deleted successfully")
            } else {
                call.respond(HttpStatusCode.NotFound, "Note not found with ID: $id")
            }
        }
    }
}
