package dev.eribas.horizon;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Horizon", version = "1", description = "My first Spring-boot API with Swagger."))
public class HorizonApplication {

	public static void main(String[] args) {
		SpringApplication.run(HorizonApplication.class, args);
	}

}
