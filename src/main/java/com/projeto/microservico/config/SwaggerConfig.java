package com.projeto.microservico.config;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Microserviço API")
                        .version("1.0")
                        .description("Documentação da API com Swagger")
                        .license(new License().name("MIT").url("https://opensource.org/licenses/MIT"))
                );
    }
}





