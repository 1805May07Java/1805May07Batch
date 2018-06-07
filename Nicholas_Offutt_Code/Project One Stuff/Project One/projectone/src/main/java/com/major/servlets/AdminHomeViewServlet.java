package com.major.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebServlet("/viewadmin")
public class AdminHomeViewServlet extends HttpServlet
{
	private static Logger logger = Logger.getLogger(AdminHomeViewServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		logger.info("attempting to depoly admin view");
		HttpSession session = req.getSession(false);
		if(session == null) 
		{
			resp.sendRedirect("index.html");
		}
		else
		{
			req.getRequestDispatcher("partials/grandview.html").forward(req,resp);
		}
	}
}
