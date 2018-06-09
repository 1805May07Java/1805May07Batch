package com.rev.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadViewServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = process(req, resp);
		req.getRequestDispatcher(url).forward(req, resp);
	}

	public static String process(HttpServletRequest req, HttpServletResponse resp) {
		switch(req.getServletPath()) {
		case "/admin.view" :{
			System.out.println("admin");
			return "partials/admin.html";
		}
		case "/user.view" :{
			System.out.println("user");
			return "partials/user.html";
		}
		case "/navbar.view":{
			System.out.println("navbar");
			return "partials/nav.html";
		}
		case "/updateuser.view":{
			System.out.println("updateUser");
			return "partials/updateinfo.html";
		}
		case "/approved.view":{
			System.out.println("aproved tickets");
			return "partials/approved.html";
		}
		case "/denied.view":{
			System.out.println("denied tickets");
			return "partials/denied.html";
		}
		case "/open.view":{
			System.out.println("open tickets");
			return "partials/open.html";
		}
		case "/addticket.view":{
			System.out.println("open add new ticket");
			return "partials/addticket.html";
		}
		}
		return null;

	}
}
