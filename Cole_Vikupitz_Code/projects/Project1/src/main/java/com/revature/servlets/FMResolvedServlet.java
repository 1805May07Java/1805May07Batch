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
import com.revature.pojos.Reimbursement;
import com.revature.service.ReimbursementService;

/**
 * Servlet implementation class FMResolvedServlet
 */
@WebServlet("/fmanager-resolved")
public class FMResolvedServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FMResolvedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Reimbursement> list = ReimbursementService.getAllResolved();
		String outJSON = "";
		ObjectMapper mapper = new ObjectMapper();

		outJSON = mapper.writeValueAsString(list);
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json");
		writer.write(outJSON);
	}

}
