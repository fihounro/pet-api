package bj.finance.petapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI documentation(){
        OpenAPI api = new OpenAPI();
        Info info = new Info();
        info.title("Pet Clinic API")
                .description("API de gestion d'une clinique vétérinaire")
                .version("1.2")
                .license(new License().name("Apache 2.0").url("http://springdoc.org"));
        api.info(info);
        return api;
    }
}
