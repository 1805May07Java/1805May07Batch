package com.ex.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.service.ReimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/dropdown")
public class LoadDropdown extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<String> options = new ArrayList<String>();
		
		ReimbursementService rs = new ReimbursementService();
		ObjectMapper mapper = new ObjectMapper();
		
		options = rs.getOptions();
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		String outJSON = mapper.writeValueAsString(options);
		out.write(outJSON);
	}
	
}
