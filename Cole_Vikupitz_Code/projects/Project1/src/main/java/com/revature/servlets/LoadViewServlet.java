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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = process(request, response);
		request.getRequestDispatcher(url).forward(request, response);
	}

	public static String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getServletPath());
		System.out.println("IN HELPER METHOD");
		switch(req.getServletPath()) {
			case "/login.view":
				return "partials/login-view.html";
			case "/create.view":
				return "partials/create-account-view.html";
			case "/submitted.view":
				return "partials/submitted-view.html";
			case "/pending.view":
				return "partials/pending-view.html";
			case "/new-request.view":
				return "partials/new-request-view.html";
		}

		return null;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("In doPost");
	}

}
