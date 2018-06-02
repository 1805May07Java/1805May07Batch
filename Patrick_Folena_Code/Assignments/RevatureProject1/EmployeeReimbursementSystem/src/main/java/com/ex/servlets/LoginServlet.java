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
import javax.servlet.http.HttpSession;

import com.ex.pojos.User;
import com.ex.service.ReimbRolesService;
import com.ex.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	static {
		System.out.println("IN LOGIN SERVLET. CHANGE PLEASE");
	}

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
		User u = mapper.readValue(json, User.class);
		
		//now that we have our request info, let's talk to our backend 
		//using none other than our service aka business logic layer
		UserService service = new UserService();
		ReimbRolesService roles = new ReimbRolesService();
		
		u = service.logIn(u.getUsername(), u.getPassword());
		
		if(u != null) { // if user exists, store them in session
			System.out.println("Saving User to Current Session");
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			if(roles.getRoleByID(u.getRole()).equals("MANAGER"))
			{
				System.out.println("Logging in");
			}
			else
			{
				System.out.println("Not Implemented Yet");
			}
		}
		
		System.out.println(u);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		String outJSON = mapper.writeValueAsString(u);
		out.write(outJSON);
	}
}
