package pl.edu.pwr.pdabrowski.lab07.api_provider.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//@EnableSwagger2
//@EnableOpenApi
public class SwaggerConfig {
    @Autowired
    private ObjectMapper objectMapper;
    public static HibernateUtil hibernateUtil = new HibernateUtil();

    void customizeObjectMapper() throws Exception {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        hibernateUtil.setUp();
    }
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.OAS_30)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("pl.edu.pwr.pdabrowski.lab07.api_provider.controller.KlientCController"))
//                .paths(PathSelectors.any())
//                .build();
////                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("My API Documentation")
//                .description("API documentation for my Spring Boot application")
//                .version("1.0.0")
//                .build();
//    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("My API")
                        .version("1.0.0")
                        .description("Some description about my API"));
    }
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("pl.edu.pwr.pdabrowski.lab07.api_provider.controller"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Przykładowe API")
//                .description("Opis przykładowego API")
//                .version("1.0.0")
//                .build();
//    }
}
