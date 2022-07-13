package bj.finance.petapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI documentationOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Pet Clinic Management API")
                        .description("Spring Pet Clinic app")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
