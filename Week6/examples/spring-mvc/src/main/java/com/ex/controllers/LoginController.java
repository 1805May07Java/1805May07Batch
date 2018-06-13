package com.ex.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ex.beans.User;
import com.ex.service.LoginService;

@Controller //Registers class as a spring bean that will manage requests
public class LoginController {
	
	static {
		System.out.println("in login controller");
	}
	

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String loadLogin(HttpSession session) {
		if(session.getAttribute("user")!=null) {
			//redirect to home page
		}
		System.out.println("GET Login");
		return "login";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(HttpServletRequest req) {
		System.out.println("Go.");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println("IN LOGIN --POST. Attempting to log in user " +
				username + " with password "+ password);
		User u = loginService.login(username, password);
		if(u == null) {
			return "redirect:login";
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			return "redirect:home";
		}
	}
	

}
