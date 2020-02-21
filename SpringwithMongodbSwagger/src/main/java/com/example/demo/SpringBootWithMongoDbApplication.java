package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.repositories.UserRepository;


@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = com.example.demo.repositories.EmployeeRepository.class)
//@EnableJpaRepositories(basePackageClasses = com.example.demo.repositories.UserRepository.class)
//@EnableSwagger2
public class SpringBootWithMongoDbApplication {

	public static void main(String[] args) {
		//lol
		SpringApplication.run(SpringBootWithMongoDbApplication.class, args);
	}

	

}
