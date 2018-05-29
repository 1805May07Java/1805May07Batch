package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("hello! in register servlet");

		String name = req.getParameter("username");
		String pass = req.getParameter("password");

		Enumeration<String> headers = req.getHeaderNames();

		System.out.println("USERNAME: " + name);
		System.out.println("PASSWORD: " + pass);
		System.out.println("HEADERS: ");
		while(headers.hasMoreElements()) {
			String header = headers.nextElement();
			System.out.println(header + ": " + req.getHeader(header));
		}
		
		System.out.println("PARAMETERS: ");
		Enumeration<String> params = req.getParameterNames();
		while(params.hasMoreElements()) {
			String p = params.nextElement();
			System.out.println(p + ": " + req.getParameter(p));
		}
		
		
		PrintWriter out = resp.getWriter();
		out.write("Welcome " + name);



	}

}
