package com.dcbank.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.sql.ClientInfoStatus;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservices REST API Documentation",
				description = "DCBank Accounts microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Akash Darekar",
						email = "tutor@dcbank.com",
						url = "https://www.dcbank.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.dcbank.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "DCBank Accounts microservice REST API Documentation",
				url = "https://www.dcbank.com/swagger-ui.html"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
