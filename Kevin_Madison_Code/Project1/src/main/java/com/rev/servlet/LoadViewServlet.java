package com.rev.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.pojo.User;

@WebServlet("*.view")
public class LoadViewServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = process(req, resp);
		req.getRequestDispatcher(url).forward(req, resp);
	}

	// adding method to process request
	public static String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getServletPath());
		System.out.println("IN HELPER METHOD");
		switch (req.getServletPath()) {
			case "/register.view": {
				return "partials/register.html";
			}
			case "/landing.view":{
				return "partials/landing.html";
			}
			case "/profile.view":{
				return "partials/profile.html";
			}
			case "/reimbursement.view":{
				return "partials/reimbursementMain.html";
			}
		}

		return null;

	}
}
