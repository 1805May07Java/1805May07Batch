package com.major.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.major.pojos.ErsUser;

@WebServlet("/viewsubmit")
public class SubmissionViewServlet extends HttpServlet
{
	private static Logger logger = Logger.getLogger(SubmissionViewServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		logger.info("attempting to depoly submission view");
		HttpSession session = req.getSession();
		if(session.getAttribute("user") == null) 
		{
			resp.sendRedirect("index.html");
		}
		else
		{
			req.getRequestDispatcher("partials/submissionview.html").forward(req,resp);
		}
	}
}
