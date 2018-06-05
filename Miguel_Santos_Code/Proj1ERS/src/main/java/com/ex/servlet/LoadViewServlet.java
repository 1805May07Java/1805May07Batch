package com.ex.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.view")
public class LoadViewServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		int id = (int) session.getAttribute("userId");
		System.out.println(id);					//Testing getAttribute
		
		String url = process(req, resp);
		req.getRequestDispatcher(url).forward(req, resp);
	}

	private String process(HttpServletRequest req, HttpServletResponse resp) {
		switch(req.getServletPath()) {
		case "/manager.view" :{
			return "partials/managerTable.html";
		}
		case "/employee.view" :{
			return "partials/employeeTable.html";
		}
		}
		return null;
	}

}
