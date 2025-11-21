package com.samir.springcampus.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo(){
        return new OpenAPI().info(new Info()
                        .title("SpringCampus API Documentation")
                        .description("API documentation for the University Management System.")
                        .version("1.0.0")
        );
    }
}
