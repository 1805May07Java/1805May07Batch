package com.ex.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojo.ERS_USERS;
import com.ex.service.ERS_USERS_Service;
//import com.ex.pojo.ERS_USERS;;
//import com.ex.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class ERS_USERS_Servlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; ///?

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("-- IN LOGIN POST --");
		
		//1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = br.readLine();
		System.out.println(json);
		
		//2. instantiate object mapper 
		ObjectMapper mapper = new ObjectMapper();
		
	
		//3. convert json string to object
		ERS_USERS u = mapper.readValue(json, ERS_USERS.class);
		
		
		//now that we have our request info, let's talk to our backend 
		//using none other than our service aka business logic layer
		ERS_USERS_Service service = new ERS_USERS_Service();
		
		u = service.login(u.getUsername(), u.getPassword());
		System.out.println(u);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		String outJSON = mapper.writeValueAsString(u);
		out.write(outJSON);
	}
}