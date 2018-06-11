package com.rev.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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

@WebServlet("/reimbursement")
public class ReimbursementServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReimbursementService  service = new ReimbursementService();
		HttpSession session = req.getSession();
		ObjectMapper mapper = new ObjectMapper();
		
		//get the user from the session
		User u = (User) session.getAttribute("user");
		
		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		
		//String path = req.getServletPath();
		if(u.getUserRoleId() == 1) {
			reimbList = service.getAllReimbById(u.getUserId());
		}else if (u.getUserRoleId() == 2) {
			reimbList = service.getAll();
		}
		//List<Reimbursement> reimbList = service.getAll();
		PrintWriter pw = resp.getWriter();
		
		//set repsonse type
		resp.setContentType("application/json");
		String outJSON = mapper.writeValueAsString(reimbList);
		pw.write(outJSON);
	}

}
