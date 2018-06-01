package com.ex.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParameterServlet extends HttpServlet {
	/*
	 * We will use this servlet to explore servlet-config
	 * and servlet-context
	 */
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("INITIALIZING PARAMETER SERVLET");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = getServletConfig().getInitParameter("title");
		System.out.println("TITLE: " + title);
		
		String star = getServletContext().getInitParameter("star");
		System.out.println(star);
		
		System.out.println("TEST" + getInitParameter("title"));
	}

}
