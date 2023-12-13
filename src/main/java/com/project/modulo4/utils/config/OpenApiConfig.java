package com.project.modulo4.utils.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "FUTBOL_DB",
                description = "FUTBOL_DB es una API REST implementada con Spring Boot y MySQL.\n" +
                        "\nOfrece un conjunto completo de operaciones para gestionar datos de jugadores, nacionalidades, ligas y clubes.",
                version = "v1.0.0"
        )
)
public class OpenApiConfig {
}
