package com.ex.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterViewServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * The HttpServletRequest interface has a method, getRequestDispatcher(),
		 * that returns a RequestDispatcher interface, which has a method, forward()
		 * to forward the request to another path
		 * The RequestDispatcher object acts as a wrapper for the resource 
		 * located at the given path
		 * The object can be used to forward a request to the resource or 
		 * to include the resource in a response 
		 * 
		 */
		req.getRequestDispatcher("partials/register.html").forward(req, resp);
		
	}
	
	

}
