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

@WebServlet("*.mod")
public class ReimbModServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		
		switch(path){
		case "/addReimb.mod": addReimb(request, response); break; 
		case "/editReimb.mod": editReimb(request, response); break;
		
		default: System.out.println("Not a Reimb Mod path"); 
		}
			
	}
	protected void addReimb(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		
		String json = "";
	
			json+= br.readLine();
		
		System.out.println(json);
		
		//2. instantiate object mapper 
		ObjectMapper mapper = new ObjectMapper();
		
	
		//3. convert json string to object
		Reimb r = mapper.readValue(json, Reimb.class);
	
		
		HttpSession hs = request.getSession();
		
		User u = (User) hs.getAttribute("user");
		r.setAuthor(u.getUserId());
		
		System.out.println("r author: " +r.getAuthor());
		ReimbServices rs = new ReimbServices();
		System.out.println("User id: "+u.getUserId());
		r = rs.addReimb(r);
		System.out.println(r);
		

		
		System.out.println(u);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		String outJSON = mapper.writeValueAsString(u);
		out.write(outJSON);
		
		
		
		
	}
	
	protected void editReimb(HttpServletRequest request, HttpServletResponse response) {
		
	}

}
