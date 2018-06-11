package com.ex.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.pojos.Reimbursement;
import com.ex.pojos.User;
import com.ex.service.ReimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;

//@WebServlet("/reimbursement")
public class ReimbursementServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("-- IN REIMB GET --");

		ObjectMapper mapper = new ObjectMapper();
		ReimbursementService service = new ReimbursementService();
		ArrayList<Reimbursement> rbs = service.getAllReimbursements();
		for(int i = 0 ; i < rbs.size(); i++) {
			
			System.out.println(rbs.get(i).getAuthor());
		}
		System.out.println("test");
	
							
		String outJSON = mapper.writeValueAsString(rbs);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(outJSON);

	}

}
