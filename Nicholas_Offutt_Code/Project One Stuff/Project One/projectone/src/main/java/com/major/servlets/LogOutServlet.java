package com.major.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.major.pojos.ErsUser;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet
{
	@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Logging user out");
		HttpSession session = req.getSession();

		if(session.getAttribute("user") == null)
		{
			//redirect to homepage if there is no session
			resp.sendRedirect("index.html");
		}

		else
		{
			session.removeAttribute("user");
			session.invalidate();
			req.getRequestDispatcher("partials/logout.html").forward(req,resp);
		}

		

	}
}
