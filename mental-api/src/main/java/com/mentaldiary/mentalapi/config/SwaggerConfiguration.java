package com.mentaldiary.mentalapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private String version;
    private String title;

    @Bean
    public Docket apiV1() {
        version = "V1";
        title = "Mental Diary " + version;

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName(version)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mentaldiary.mentalapi.v1"))
                .paths(PathSelectors.ant("/v1/**"))
                .build()
                .apiInfo(apiInfo(title, version));
    }


    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfo(
                title,
                "Mental-Diary API Docs",
                version,
                "www.mental-diary.com",
                new Contact("Contact Me", "www.mental-diary.com", "gomieti@naver.com"),
                "Licenses",

                "www.mental-diary.com",

                new ArrayList<>());
    }


}
