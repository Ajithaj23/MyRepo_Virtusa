package com.smart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages= {"com.smart.service","com.smart.controller","com.smart.config"})

public class BroadcastingChatServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BroadcastingChatServerApplication.class, args);
	}

}
