package com.example.exercici5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Exercici5Application {
	public static void main(String[] args) {
		SpringApplication.run(Exercici5Application.class, args);
	}
}