package com.springcaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class A14SpringCachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(A14SpringCachingApplication.class, args);
	}

}
