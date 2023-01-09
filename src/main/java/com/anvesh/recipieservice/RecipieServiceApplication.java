package com.anvesh.recipieservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableSwagger2
public class RecipieServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipieServiceApplication.class, args);
    }

   /* @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.anvesh")).build();
    }*/
}
