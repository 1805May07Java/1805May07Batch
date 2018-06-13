package com.ex.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String getHomepage(HttpSession s) {
		if(s.getAttribute("user")!=null)
			return "home";
		else
			return "redirect: login";
	}
}
