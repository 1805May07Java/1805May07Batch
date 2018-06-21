package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // enables or "turns on" eureka 
@SpringBootApplication
public class FlashCardEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashCardEurekaApplication.class, args);
	}
}
