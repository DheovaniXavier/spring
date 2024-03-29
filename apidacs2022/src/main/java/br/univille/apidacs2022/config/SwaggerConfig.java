package br.univille.apidacs2022.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                    .title("REST API DACS")
                    .description("Exemplo de documentação da API")
                    .termsOfServiceUrl("")
                    .license("")
                    .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                    .version("v1")
                    .build();
    }

    @Bean
    public Docket api2() {
        return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("br.univille.apidacs2022.api"))
                    .paths(PathSelectors.any())
                    .build()
                    .apiInfo(apiInfo());
    }

}
