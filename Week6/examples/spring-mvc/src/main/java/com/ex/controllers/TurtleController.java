package com.ex.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ex.beans.Turtle;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value="/turtle")
public class TurtleController {
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public Turtle getTurtle() {
		return null;
	}

}
