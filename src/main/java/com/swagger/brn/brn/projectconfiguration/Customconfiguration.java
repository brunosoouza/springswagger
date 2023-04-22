package com.swagger.brn.brn.projectconfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Customconfiguration implements WebMvcConfigurer { //Implementando content negotiation


    //Configurando o content negotiation para trabalhar nao somente com json mas tambem com xml

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        WebMvcConfigurer.super.configureContentNegotiation(configurer);

        configurer.favorParameter(true) // Indica para aceitar parametro de configuração na url
                .parameterName("mediaType") //nome do parametro
                .ignoreAcceptHeader(false) //ignora esse parametro no header
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON) //Informa ao spring a forma de como a api vai trabalhar os dados por padrão
                .mediaType("json", MediaType.APPLICATION_JSON) //Habilita o processamento de dados json
                .mediaType("xml", MediaType.APPLICATION_XML); //Habilita trabalhar com dados xml
    }
}