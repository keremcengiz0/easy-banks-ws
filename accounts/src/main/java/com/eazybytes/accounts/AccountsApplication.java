package com.eazybytes.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@OpenAPIDefinition(info = @Info(
        title = "Accounts microservice REST API Documentation",
        description = "EazyBank Accounts microservice REST API Documentation",
        version = "1.0",
        contact = @Contact(url = "https://github.com/keremcengiz0", name = "Kerem", email = "keremcengiz0@hotmail.com"),
        license =  @License(name = "Apache 2.0",
                            url = "https://github.com/keremcengiz0")),
        externalDocs = @ExternalDocumentation(description = "EazyBank Accounts microservice REST API Documentation"))
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}

