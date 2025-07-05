package com.restaurante.sistema_restaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
@OpenAPIDefinition(
		info = @Info(
				title = "Sistema Restaurante",
				version = "1.0",
				description = "Descrição da minha API",
				contact = @Contact(
						name = "Rosyane Iris",
						email = "rosyaneiris201@gmail.com",
						url = "https://github.com/Rosy201")


		)
)
@SpringBootApplication
public class SistemaRestauranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaRestauranteApplication.class, args);
	}

}
