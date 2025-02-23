package com.vincebiins

import com.vincebiins.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureDependencyInjections()
    configureSerialization()
    configureMonitoring()
    configureRouting()
}
