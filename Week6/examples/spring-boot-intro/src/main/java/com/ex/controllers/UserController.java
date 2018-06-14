package com.ex.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.model.User;
import com.ex.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService service;
	/**
	 * @return List of users
	 */
	@RequestMapping(method=RequestMethod.GET)
	public List<User> getAll(){
		return service.getAll();
	}
	
	@RequestMapping(method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> add(@RequestBody User u){
			u = service.addUser(u);
			if(u == null) return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<User>(u, HttpStatus.CREATED);
	
	}
	
	public ResponseEntity<User> getByUsername(@RequestBody String name){
		return null;
	}
	
	public ResponseEntity<User> updateUser(@RequestBody User u){
		return null;
	}
	
	public ResponseEntity<User> getById(@PathVariable int id){
		return null;
	}
	
	public ResponseEntity<User> delete(@RequestBody User u){
		return null;
	}
	
	
	
	

}
