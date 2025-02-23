package com.vincebiins.plugins
import com.vincebiins.repository.NoteRepository
import com.vincebiins.repository.NoteRepositoryImpl
import com.vincebiins.controller.NoteController
import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureDependencyInjections() {
    install(Koin) {
        slf4jLogger()
        modules(module {
            single<NoteRepository> { NoteRepositoryImpl() }
            single { NoteController(get()) }
        })
    }
}
