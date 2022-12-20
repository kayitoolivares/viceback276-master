package com.leoolivares.viceback276;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableJpaRepositories
public class Viceback276Application {

	public static void main(String[] args) {
		SpringApplication.run(Viceback276Application.class, args);
	}

}
