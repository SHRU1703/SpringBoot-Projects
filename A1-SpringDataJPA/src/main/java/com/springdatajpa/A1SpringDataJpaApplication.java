package com.springdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com.springdatajpa.repository") // Specify your repository package
@EntityScan(basePackages = "com.springdatajpa.entities") // Specify your entity package
@SpringBootApplication
public class A1SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(A1SpringDataJpaApplication.class, args);
	}

}
