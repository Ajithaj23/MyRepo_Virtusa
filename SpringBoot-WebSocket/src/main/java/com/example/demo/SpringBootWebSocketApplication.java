package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages=("com.smart.controller"))
public class SpringBootWebSocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebSocketApplication.class, args);
	}

}
