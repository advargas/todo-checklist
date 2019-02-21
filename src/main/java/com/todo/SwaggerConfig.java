package com.todo;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Value("${endpoint.base}")
	private String apiBaseUrl;

	private static final String HTTP_URL = "https://github.com/advargas";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).
				select().
				apis(RequestHandlerSelectors.any()).
				paths(PathSelectors.regex(apiBaseUrl + ".*")).
				build().
				apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("API Rest TODO Checklist", "API Rest TODO Checklist - Spring Boot.", "API TOS",
				"Terms of service", new Contact("Adriana Vargas", HTTP_URL, "adriana.vargas@gmail.com"),
				"License of API", HTTP_URL, Collections.emptyList());
	}

}
