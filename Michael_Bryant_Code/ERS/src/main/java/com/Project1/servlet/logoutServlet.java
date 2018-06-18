package com.Project1.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout")
public class logoutServlet extends HttpServlet{
	
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        System.out.println("before sessions");
	        HttpSession session = req.getSession(false);
	        if(session != null) {
	            session.removeAttribute("user");
	            session.invalidate();
	           // req.getRequestDispatcher("index.html").forward(req, resp);
	        }
	    }
	}

