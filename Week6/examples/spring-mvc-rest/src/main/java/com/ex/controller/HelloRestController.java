package com.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.beans.User;
import com.ex.service.UserService;

@RestController
@RequestMapping("/api")
public class HelloRestController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String hello() {
		System.out.println("in hello method-----------");
		return "Welcome to Spring MVC!";
	}
	
	@RequestMapping(method = RequestMethod.GET, 
			value="/users", produces=MediaType.APPLICATION_JSON_VALUE )
	public List<User> getAll(){
		 return service.getAll();
	}
	
	@GetMapping(value="/user")
	public User getById() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE, value="/users")
	public User add(@RequestBody User u) {
		return service.save(u);
	}
	

}
