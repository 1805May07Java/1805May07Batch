package com.rev.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojo.Reimbursement;
import com.rev.pojo.User;
import com.rev.service.ReimbursementService;

@WebServlet("/resolveReimbursement")
public class ResolveReimbursementServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		json += br.readLine();
		
		System.out.println(json);

		// 2. instantiate object mapper
		ObjectMapper mapper = new ObjectMapper();

		// 3. convert json string to object
		Reimbursement r = mapper.readValue(json, Reimbursement.class);

		HttpSession session = req.getSession(false);
		
		User u = (User)session.getAttribute("user");
		r.setResolver(u.getUserId());
		System.out.println(r.toString());
		
		
		
		// now that we have our request info, let's talk to our backend
		// using none other than our service aka business logic layer
		ReimbursementService service = new ReimbursementService();
		
		service.resolveReimbursement(r.getId(), r.getResolver(), r.getStatusId());
		
		
	}
}
