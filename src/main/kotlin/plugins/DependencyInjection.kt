package com.vincebiins.plugins
import com.vincebiins.domain.repository.NoteRepository
import com.vincebiins.infrastructure.repository.NoteRepositoryImpl
import com.vincebiins.presentation.controller.NoteController
import com.vincebiins.application.service.NoteService
import com.vincebiins.application.service.NoteServiceImpl
import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureDependencyInjections() {
    install(Koin) {
        slf4jLogger()
        modules(module {

            single<NoteRepository> { NoteRepositoryImpl() }
            single<NoteService> { NoteServiceImpl(get()) }
            single { NoteController(get()) }
        })
    }
}
