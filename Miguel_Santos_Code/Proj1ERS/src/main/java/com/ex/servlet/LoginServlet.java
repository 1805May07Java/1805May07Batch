package com.ex.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.pojos.ERSUser;
import com.ex.service.ERSUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(value="/login", loadOnStartup=1)
public class LoginServlet extends HttpServlet{
	static {
		System.out.println("IN LOGIN SERVLET. CHANGE PLEASE");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("IN DO GET");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("In login Servlet");
		
		Stream<String> text = req.getReader().lines(); 
		String json = text.collect(Collectors.joining("")).toString();
		
		System.out.println(json);
		
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
