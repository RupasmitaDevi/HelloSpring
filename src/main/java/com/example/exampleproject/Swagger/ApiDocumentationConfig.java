package com.example.exampleproject.Swagger;

import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "Greeting API",
                version = "V12.0.12",
                title = "Hello Spring",
                contact = @Contact(
                        name = "Rupasmita Devi",
                        email = "rupasmita.devi@gmail.com",
                        url = "https://github.com/RupasmitaDevi"
                )
        ),
        consumes = {"application/json", "application/xml", "text/html"},
        produces = {"application/json", "application/xml", "text/html"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS}
        )
public interface ApiDocumentationConfig {

}