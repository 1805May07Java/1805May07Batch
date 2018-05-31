package com.ex.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Logging user out");
		
		
		HttpSession session = req.getSession(false);
		
		if( session == null) {
			//redirect to homepage if there is no session
			resp.sendRedirect("login.html");
		}
		else {
			session.removeAttribute("user");
			session.invalidate();
		}
		
	}
	
}
