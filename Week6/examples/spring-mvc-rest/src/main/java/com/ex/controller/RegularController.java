package com.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ex.beans.User;
import com.ex.service.UserService;

@Controller
public class RegularController {

	@Autowired
	UserService service;
	
	@RequestMapping(value="/reg", method=RequestMethod.GET)
	@ResponseBody //only difference between @Controller and @RestController is the need for this annotation
	public List<User> getAllUsers() {
		return service.getAll();
	}
}
