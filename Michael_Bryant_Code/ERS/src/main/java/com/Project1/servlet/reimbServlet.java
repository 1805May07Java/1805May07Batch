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

import com.Project1.pojos.Reimb;
import com.Project1.pojos.User;
import com.Project1.service.ReimbServices;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("*.table")
public class reimbServlet extends HttpServlet {
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		System.out.println(url);
		switch(url) {
		case "/admin.table": admin(request, response); break;
		case "/employee.table": employee(request, response); break;
		}

	}
	
	protected void admin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Admin Table");
		//1. get received JSON data from request
				BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
				/*
				String json = "";
			
					json+= br.readLine();
				
				System.out.println(json);
				
				
				//2. instantiate object mapper 
				ObjectMapper mapper = new ObjectMapper();
				
			
				//3. convert json string to object
				Reimb u = mapper.readValue(json, Reimb.class);
				*/
				
				ObjectMapper mapper = new ObjectMapper();
				
				//now that we have our request info, let's talk to our backend 
				//using none other than our service aka business logic layer
				ReimbServices service = new ReimbServices();
				

				
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				
				String outJSON = mapper.writeValueAsString(service.getAll());
				out.write(outJSON);
	}
	
	protected void employee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Employee Table");
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		ObjectMapper mapper = new ObjectMapper();
		
		//now that we have our request info, let's talk to our backend 
		//using none other than our service aka business logic layer
		ReimbServices service = new ReimbServices();
		

		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		HttpSession hs = request.getSession();
		
		String outJSON = mapper.writeValueAsString(service.getById(((User) hs.getAttribute("user")).getUserId()));
		System.out.println(outJSON);
		out.write(outJSON);
	}

}
