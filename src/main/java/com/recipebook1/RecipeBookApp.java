package com.recipebook1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EntityScan
@EnableJpaAuditing
public class RecipeBookApp {
	public static void main(String[] args) {
		SpringApplication.run(RecipeBookApp.class, args);
	}
}
