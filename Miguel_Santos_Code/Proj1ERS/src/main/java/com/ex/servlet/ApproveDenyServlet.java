package com.ex.servlet;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.service.ReimbursementService;

@WebServlet("/approve")
public class ApproveDenyServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		int id = (int) session.getAttribute("userId");
		
		Stream<String> text = req.getReader().lines(); 
		String reqBody = text.collect(Collectors.joining("")).toString();
		
		String params[] = reqBody.split(":");
		
		ReimbursementService rs = new ReimbursementService();
		rs.approveDeny(id, params[0], params[1]);
	}
	
}
