package com.rev.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.K;
import com.rev.pojos.ReimAll;
import com.rev.pojos.Reimburse;
import com.rev.pojos.User;
import com.rev.service.ReimburseService;

@WebServlet(loadOnStartup = 1, urlPatterns= {"/reim", "/reim/*"})
public class ReimServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReimburseService service = new ReimburseService();
		HttpSession session = req.getSession(false);
		ObjectMapper mapper = new ObjectMapper();
		User u = (User) session.getAttribute("user");
		//String path = req.getServletPath();
		String path = req.getPathInfo();
		if(path.equals("/all")) {
			if(u.getRole() == 2) {
				ArrayList<ReimAll> r = service.getAllReimb();
				PrintWriter out = resp.getWriter();
				resp.setContentType("application/json");
				String outJSON = mapper.writeValueAsString(r);
				out.write(outJSON);
			}
			if(u.getRole() == 1) {
				ArrayList<ReimAll> r = service.getAllReimb(u.getUserID());
				PrintWriter out = resp.getWriter();
				resp.setContentType("application/json");
				String outJSON = mapper.writeValueAsString(r);
				out.write(outJSON);
			}
		}
		if(path.equals("/apr")) {
			ArrayList<ReimAll> r = service.getAprReimb();
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			String outJSON = mapper.writeValueAsString(r);
			out.write(outJSON);
		}
		if(path.equals("/den")) {
			ArrayList<ReimAll> r = service.getDenReimb();
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			String outJSON = mapper.writeValueAsString(r);
			out.write(outJSON);
		}
		if(path.equals("/pend")) {
			ArrayList<ReimAll> r = service.getPendReimb();
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			String outJSON = mapper.writeValueAsString(r);
			out.write(outJSON);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		ObjectMapper mapper = new ObjectMapper();

		String json = br.readLine();
		Reimburse r = mapper.readValue(json, Reimburse.class);
		//r.setResolver(0);
		ReimburseService service = new ReimburseService();
		boolean t = service.add(r); 
		if((t == true)) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/text");
			out.write("true");
		}
		else {
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/text");
			out.write("false");
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		ObjectMapper mapper = new ObjectMapper();
		HttpSession session = req.getSession(false);
		User u = (User) session.getAttribute("user");
		
		String json = br.readLine();
	
		K r = mapper.readValue(json, K.class);
		System.out.println(r.getTicketID());
		ReimburseService service = new ReimburseService();
		String path = req.getPathInfo();
		if(path.equals("/app")) {
			System.out.println("in app");
			service.updateStat(r.getTicketID(), 2, u.getUserID());
		}
		if(path.equals("/den")) {
			System.out.println("in den");
			service.updateStat(r.getTicketID(), 3, u.getUserID());
		}
	}
}
