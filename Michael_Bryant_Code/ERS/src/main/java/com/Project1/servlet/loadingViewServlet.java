package com.Project1.servlet;


import java.io.IOException;
import com.Project1.pojos.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.view") 
public class loadingViewServlet extends HttpServlet {

       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = process (request, response);
		System.out.println(url);
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getServletPath());
		System.out.println("IN HELPER METHOD");
		int roleId = 0;
		
		HttpSession hs = request.getSession();
		if(hs.getAttribute("user") != null) {
		roleId =((User) hs.getAttribute("user")).getUserRoleId();
		System.out.println(roleId);
		} 
		
		switch(request.getServletPath()) {
		
		case "/registered.view": return ( (roleId > 0) ? "partials/manager_page.html" : "partials/norm_page.html");
		
		case "/register.view": return "partials/register.html";
		
		}

		return null;
		
	}

}
