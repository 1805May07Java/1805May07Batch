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

//@WebServlet("/getuserreqs")
public class GetUserRequests extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("-- IN REIMB GET --");

		ObjectMapper mapper = new ObjectMapper();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = br.readLine();
		System.out.println(json);
		User u = mapper.readValue(json, User.class);
		
		ReimbursementService service = new ReimbursementService();
		System.out.println("testservlet");
		List<Reimbursement> rbs = service.getUserReimbursements(u.getId());
		System.out.println(u.getId());
		
		System.out.println("test");
	
		String outJSON = mapper.writeValueAsString(rbs);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(outJSON);

	}

}