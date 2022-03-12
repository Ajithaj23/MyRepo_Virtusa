package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.repository")
@EntityScan("com.example.beans")
@ComponentScan(basePackages= {"com.example.service","com.example.controller","com.example.config"})
public class SpringBootCrudUpload1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudUpload1Application.class, args);
	}

}
