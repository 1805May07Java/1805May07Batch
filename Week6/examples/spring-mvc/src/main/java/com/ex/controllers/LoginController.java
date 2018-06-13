package com.ex.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ex.beans.User;
import com.ex.service.LoginService;

@Controller //Registers class as a spring bean that will manage requests
@RequestMapping(value="/login") //specify what requests you want this controller to handle
public class LoginController {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	private LoginService loginService;

	@RequestMapping(method=RequestMethod.GET)
	public String loadLogin(HttpSession session) {
		if(session.getAttribute("user")!=null) {
			//redirect to home page
		} 
		return "static/login.html";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(String username, String password, HttpSession session) {
		System.out.println("IN LOGIN --POST. Attempting to log in user " +
				username + " with password "+ password);
		User u = loginService.login(username, password);
		if(u == null) {
			// reload login page
		} else {
			// load home page
			session.setAttribute("user", u);
		}
		
		return null;
	}
	

}
