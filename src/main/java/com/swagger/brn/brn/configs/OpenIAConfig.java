package com.swagger.brn.brn.configs;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenIAConfig {

    // customizado o cabeçalho do swagger
    @Bean
    public OpenAPI customOpenAPI(){
        Info informations = new Info();
        informations.title("Rapida documentação da Api com swagger");
        informations.description("Um projeto onde o foco esta em documentar a API utilizando swagger");
        informations.version("v1");
        informations.termsOfService("estaurlnaoexistedeproposito");
        informations.license(new License().name("MIT").url("estaurlnaoexistedeproposito"));

        return new OpenAPI().info(informations);
    }


}
