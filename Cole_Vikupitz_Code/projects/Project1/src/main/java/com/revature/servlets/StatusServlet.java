/*
 * StatusServlet.java
 * Author: Cole Vikupitz
 *
 */


package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Status;
import com.revature.service.StatusService;

/**
 * Servlet implementation class StatusServlet
 */
@WebServlet("/status")
public class StatusServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Status> list = StatusService.getAll();
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		String outJSON = mapper.writeValueAsString(list);
		out.write(outJSON);
	}

}
