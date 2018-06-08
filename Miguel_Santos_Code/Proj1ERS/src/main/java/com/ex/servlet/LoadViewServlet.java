package com.ex.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/view")
public class LoadViewServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in do get of load view");
		HttpSession session = req.getSession(false);
		//int id = (int) session.getAttribute("userId");
		int role = (int) session.getAttribute("userRoleId");
		
		System.out.println("role is " + role);
		
		String url = null;
		if (role == 1) url = "partials/employeeTable.html";
		else url = "partials/managerTable.html";

		req.getRequestDispatcher(url).include(req, resp);
		
//		PrintWriter out = resp.getWriter();
//		resp.setContentType("text/html");
//		
//		out.write(url);
//		resp.reset();	
		
		
	}

	private String process(int role) {
		if (role == 1) return "partials/employeeTable.html";
		else return "partials/managerTable.html";
		
	}
	
//	private String process(int role){
//		if(role == 1) return "<div id=\"tableview\" class=\"container mt-3\">\r\n" + 
//				"	<input class=\"form-control\" id=\"myInput\" type=\"text\" placeholder=\"Search..\">\r\n" + 
//				"	<br>\r\n" + 
//				"	<table class=\"table table-bordered table-hover table-responsive-lg\">\r\n" + 
//				"		<thead class=\"thead-light\">\r\n" + 
//				"			<tr>\r\n" + 
//				"				<th>Submitted</th>\r\n" + 
//				"				<th>Firstname</th>\r\n" + 
//				"				<th>Lastname</th>\r\n" + 
//				"				<th>Status</th>\r\n" + 
//				"				<th>Type</th>\r\n" + 
//				"				<th>Description</th>\r\n" + 
//				"				<th>Amount</th>\r\n" + 
//				"				<th>Resolver</th>\r\n" + 
//				"				<th>Resolved</th>\r\n" + 
//				"			</tr>\r\n" + 
//				"		</thead>\r\n" + 
//				"		<tbody id=\"myTable\">\r\n" + 
//				"		\r\n" + 
//				"		</tbody>\r\n" + 
//				"	</table>\r\n" + 
//				"\r\n" + 
//				"</div>";
//	 	else return "<div id=\"tableview\" class=\"container mt-3\">\r\n" + 
//	 			"	<br>\r\n" + 
//	 			"	<table class=\"table table-bordered table-hover table-responsive-lg\">\r\n" + 
//	 			"		<thead class=\"thead-light\">\r\n" + 
//	 			"			<tr>\r\n" + 
//	 			"				<th>Status</th>\r\n" + 
//	 			"				<th>Type</th>\r\n" + 
//	 			"				<th>Description</th>\r\n" + 
//	 			"				<th>Amount</th>\r\n" + 
//	 			"				<th>Submitted</th>\r\n" + 
//	 			"				<th>Resolver</th>\r\n" + 
//	 			"				<th>Resolved</th>\r\n" + 
//	 			"			</tr>\r\n" + 
//	 			"		</thead>\r\n" + 
//	 			"		<tbody id=\"myTable\">\r\n" + 
//	 			"		\r\n" + 
//	 			"		</tbody>\r\n" + 
//	 			"	</table>\r\n" + 
//	 			"\r\n" + 
//	 			"</div>";
//	  }
//	  
//	 

}
