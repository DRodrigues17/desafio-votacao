package com.br.org.dbserver.danielrodrigues.desafiovotacao.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("desafio votação")
                        .description("Documentação do desafio sicredi de Daniel Rodrigues ")
                        .version("1.0.0"))
                .components(new Components());
    }
}
