package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class App {
	
	/*
	 * Business service
	 * 	must register with Eureka: @EnableEurekaClient	
	 */

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
