package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pat")
public class HTTPExampleServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		System.out.println("IN INIT METHOD OF HTTP SERVLET");
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		
		System.out.println("HTTP DESTROYED");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("IN DOGET METHOD");
		PrintWriter out = resp.getWriter();
		String html = "<h1> Hello <i>Genesis</i> </h1>";
		resp.setContentType("text/html");
		out.write("PRINTING FROM HTTP METHOD<br>" + html);
	}
	
	

}
