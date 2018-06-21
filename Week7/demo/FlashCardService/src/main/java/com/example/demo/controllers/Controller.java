package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.beans.FlashCard;

@RestController
public class Controller {

	@RequestMapping("/fc")
	public String test() {
		System.out.println("in test");
		return "hello flashcard";
	}
	
	 //using another microservice
	@LoadBalanced 
	@Bean  //the object returned by this method is now a spring bean 
	public RestTemplate buldRestTemplate(RestTemplateBuilder rtBuilder) {
		return rtBuilder.build();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/flash")
	public FlashCard getCard() {
		String url = "http://Flashcard-Service-2/getfc";
		System.out.println("testing");
		FlashCard fc = restTemplate.getForObject(url, FlashCard.class);
		return fc;	
		
	}
}
