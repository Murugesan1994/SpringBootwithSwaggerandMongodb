package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.repositories.UserRepository;


@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = com.example.demo.repositories.UserRepository.class)
//@EnableJpaRepositories(basePackageClasses = com.example.demo.repositories.UserRepository.class)
//@EnableSwagger2
public class SpringBootWithMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithMongoDbApplication.class, args);
	}

	/*
	 * @Bean protected Docket swaggerConfiguration()
	 * 
	 * { return new Docket(DocumentationType.SWAGGER_2) .select()
	 * .paths(PathSelectors.ant("/api/**"))
	 * .apis(RequestHandlerSelectors.basePackage("com.example.demo")).build().
	 * apiInfo(apiDetails());
	 * 
	 * 
	 * } private ApiInfo apiDetails() { return new
	 * ApiInfo("Mongo-DB-","This Project about spring boot with MongoDb","Sample",
	 * "HI", new springfox.documentation.service.Contact("Manikandan","Diatoz.com",
	 * "abc.gmail.com"), "API ","Swagger.api", Collections.emptyList());
	 * 
	 * }
	 * 
	 * @Bean Docket SwaggerConfiguration() { return new
	 * Docket(DocumentationType.SWAGGER_2) .select()
	 * .paths(PathSelectors.ant("/api/*"))
	 * .apis(RequestHandlerSelectors.basePackage("com.example.demo")).build();
	 * 
	 * }
	 */

}
