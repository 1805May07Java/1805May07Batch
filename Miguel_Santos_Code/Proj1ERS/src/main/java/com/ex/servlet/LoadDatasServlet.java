package com.ex.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.pojos.Reimbursement;
import com.ex.service.ReimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/data")
public class LoadDatasServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Reimbursement> data = new ArrayList<Reimbursement>();
		
		HttpSession session = req.getSession(false);
		int id = (int) session.getAttribute("userId");
		int role = (int) session.getAttribute("userRoleId");
		
		ReimbursementService rs = new ReimbursementService();
		ObjectMapper mapper = new ObjectMapper();
		
		data = rs.getData(id, role);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		String outJSON = mapper.writeValueAsString(data);
		System.out.println(outJSON);
		out.write(outJSON);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		int id = (int) session.getAttribute("userId");
		
		Stream<String> text = req.getReader().lines(); 
		String json = text.collect(Collectors.joining("")).toString();
		
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement r = mapper.readValue(json, Reimbursement.class);
		
		ReimbursementService rs = new ReimbursementService();
		rs.addReimbursement(id, r.getAmount(), r.getDescription(), r.getType_id());
	}
	
}
