package com.ex.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadViewServlet
 */

@WebServlet("*.view")
public class LoadViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = process(req, resp);
		req.getRequestDispatcher(url).forward(req, resp);
	}

	// adding method to process request
	public static String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getServletPath());
		System.out.println("IN HELPER METHOD");
		switch(req.getServletPath()) {
		case "/1.view" :{
			return "partials/employee.html";
		}
		case "/2.view" :{
			return "partials/managerReimbursementListView.html";
		}
		}
		return null;
	}
}
