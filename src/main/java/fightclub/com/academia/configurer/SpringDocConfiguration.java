package fightclub.com.academia.configurer;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI FigthGymSpringDoc() {
        return new OpenAPI()
                .info(new Info().title("Figth Gym api")
                        .description("Figth Gym application monolitc")
                        .version("v0.0.1"))
                .externalDocs(new ExternalDocumentation()
                        .description("Figth gym  wiki documentation")
                        .url("https://github.com/lucasciannella/FigthGym"));
    }
}