package com.major.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebServlet("/viewregister")
public class RegisterViewServlet extends HttpServlet
{
private static Logger logger = Logger.getLogger(RegisterViewServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		logger.info("attempting to depoly registration view");
		req.getRequestDispatcher("partials/registerview.html").forward(req,resp);
		
	}
}
