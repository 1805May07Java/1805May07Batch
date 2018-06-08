package com.Project1.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Project1.pojos.User;
import com.Project1.service.UserServices;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class mainServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	System.out.println("-- IN LOGIN POST --");
		
		//1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		
		String json = "";
	
			json+= br.readLine();
		
		System.out.println(json);
		
		//2. instantiate object mapper 
		ObjectMapper mapper = new ObjectMapper();
		
	
		//3. convert json string to object
		User u = mapper.readValue(json, User.class);
		
		
		//now that we have our request info, let's talk to our backend 
		//using none other than our service aka business logic layer
		UserServices service = new UserServices();
		
		u = service.login(u.getUsername(), u.getPassword());
		if(u != null) { // if user exists, store them in session
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
		}
		
		
		System.out.println(u);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		String outJSON = mapper.writeValueAsString(u);
		out.write(outJSON);
	}

}
