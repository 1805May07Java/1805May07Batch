package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.FlashCard;

@RestController
public class Controller {
	//controller 2
	@GetMapping("/getfc")
	public FlashCard getFC(){
		return new FlashCard(1, "wazaaaaaaam", "test");
	}

}
