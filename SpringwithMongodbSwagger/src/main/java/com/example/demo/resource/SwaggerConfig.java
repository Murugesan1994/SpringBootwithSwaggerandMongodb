package com.example.demo.resource;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackageClasses = { EmpController.class, CompController.class })
@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo")).paths(regex("/api.*")).build()
				.apiInfo(apiDetails());

	}

	private ApiInfo apiDetails() {
		return new ApiInfo("Mongo-DB-", "This Project about spring boot with MongoDb", "Sample", "HI",
				new springfox.documentation.service.Contact("Murugesan", "ijk.com", "abc.gmail.com"), "API ",
				"Swagger.api", Collections.emptyList());

	}

	 @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	  
	  registry .addResourceHandler("swagger-ui.html")
	  .addResourceLocations("classpath:/META-INF/resources/");
	  
	  registry .addResourceHandler("/webjars/**")
	  .addResourceLocations("classpath:/META-INF/resources/webjars/"); }
	  
	
}
