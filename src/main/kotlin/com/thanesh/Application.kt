package com.thanesh

import io.micronaut.runtime.Micronaut.run
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.info.*

@OpenAPIDefinition(
    info = Info(
        title = "kotlin-micronaut-crud",
        version = "0.0"
    )
)
object Api {
}

fun main(args: Array<String>) {
    run(*args)
}

