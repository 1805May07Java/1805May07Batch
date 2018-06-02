package com.ex.servlet;

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

import com.ex.pojos.ERSUser;
import com.ex.service.ERSUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("In login Servlet");
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = br.readLine();
		
		ObjectMapper mapper = new ObjectMapper();
		
		ERSUser u = mapper.readValue(json, ERSUser.class);
		
		ERSUserService us = new ERSUserService();
		
		u = us.validUnPw(u.getUsername(), u.getPassword());
		if(u != null) {
			HttpSession session = req.getSession();
			session.setAttribute("userId", u.getId());
			session.setAttribute("userRoleId", u.getRoleId());
		}
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		String outJSON = mapper.writeValueAsString(u);
		out.write(outJSON);
	}
	
}
