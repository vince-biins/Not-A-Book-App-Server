package com.vincebiins.plugins

import com.vincebiins.routes.NoteController
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Application.configureRouting() {
    val noteController: NoteController by inject()
    routing {

        with(noteController) {
            noteRoutes()
        }

        staticResources("", "static")
    }
}
