/*
 * LoadViewServlet.java
 * Author: Cole Vikupitz
 *
 */


package com.revature.servlets;

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

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = process(request, response);
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected static String process(HttpServletRequest req, HttpServletResponse resp) {

		switch(req.getServletPath()) {
			case "/fm-pending.view":
				return "partials/fm-pending-view.html";
			case "/fm-resolved.view":
				return "partials/fm-resolved-view.html";
			case "/login.view":
				return "partials/login-view.html";
			case "/resolved.view":
				return "partials/resolved-view.html";
			case "/pending.view":
				return "partials/pending-view.html";
			case "/new-request.view":
				return "partials/new-request-view.html";
		}

		return null;

	}

}
