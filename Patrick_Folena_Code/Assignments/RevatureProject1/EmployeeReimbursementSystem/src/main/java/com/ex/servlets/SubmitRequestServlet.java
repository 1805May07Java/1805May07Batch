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
import javax.servlet.http.HttpSession;

import com.ex.pojos.Reimbursement;
import com.ex.pojos.User;
import com.ex.service.ReimbRolesService;
import com.ex.service.ReimbursementService;
import com.ex.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/submitRequest")
public class SubmitRequestServlet extends HttpServlet {
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("-- SUBMITTING REQUEST --");
		
		//1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = br.readLine();
		System.out.println(json);
		
		//2. instantiate object mapper 
		ObjectMapper mapper = new ObjectMapper();
		
		//3. convert json string to object
		Reimbursement r = mapper.readValue(json, Reimbursement.class);
		
		//now that we have our request info, let's talk to our backend 
		//using none other than our service aka business logic layer
		ReimbursementService service = new ReimbursementService();
		User currUser = (User) req.getSession(false).getAttribute("user");
		
		r.setAuthor(currUser.getID());
		
		service.addReimbursement(r);
		
		System.out.println(r);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		String outJSON = mapper.writeValueAsString(r);
		out.write(outJSON);
	}

}
