package com.ex.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojos.Reimbursement;
import com.ex.pojos.User;
import com.ex.service.ReimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class UpdateReimbursementServlet
 */
@WebServlet("/updateReimbursement")
public class UpdateReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("-- UPDATING REQUEST --");
		
		//1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = br.readLine();
		System.out.println(json);
		
		//2. instantiate object mapper 
		ObjectMapper mapper = new ObjectMapper();
		
		//3. convert json string to object
		Reimbursement rData = mapper.readValue(json, Reimbursement.class);
		
		//now that we have our request info, let's talk to our backend 
		//using none other than our service aka business logic layer
		ReimbursementService service = new ReimbursementService();
		Reimbursement rNew = service.getReimbByID(rData.getID());
		
		User currUser = (User) req.getSession(false).getAttribute("CurLoginUser");
		
		rNew.setResolver(currUser.getUserID());
		rNew.setResolveTime(new Date());
		rNew.setStatus(rData.getStatus());
		
		System.out.println(rNew.getStatus());
		
		service.updateReimbursement(rNew);
		
		System.out.println(rNew);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		String outJSON = mapper.writeValueAsString(rNew);
		out.write(outJSON);
	}
}
