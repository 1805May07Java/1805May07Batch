/*
 * EmpPendingServlet.java
 * Author: Cole Vikupitz
 *
 */


package com.revature.servlets;

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
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.service.ReimbursementService;

/**
 * Servlet implementation class EmpPendingServlet
 */
@WebServlet("/employee-pending")
public class EmpPendingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpPendingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		List<Reimbursement> list = new ArrayList<Reimbursement>();
		if (session != null) {
			User user = (User) session.getAttribute("user");
			list = ReimbursementService.getAllPending(user.getId());
		}

		String outJSON = "";
		ObjectMapper mapper = new ObjectMapper();
		outJSON = mapper.writeValueAsString(list);
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json");
		writer.write(outJSON);
	}

}
