/*
 * NewRequestServlet.java
 * Author: Cole Vikupitz
 *
 */


package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.service.ReimbursementService;

/**
 * Servlet implementation class NewRequestServlet
 */
@WebServlet("/add-request")
public class NewRequestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BufferedReader br = new BufferedReader(
				new InputStreamReader(request.getInputStream()));

		String json = "";
		json = br.readLine();

		ObjectMapper mapper = new ObjectMapper();
		Reimbursement re = mapper.readValue(json, Reimbursement.class);
		User user = (User) request.getSession().getAttribute("user");
		re.setSender(user.getId());

		ReimbursementService.addRequest(re);

	}

}
