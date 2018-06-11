package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
 * Servlet implementation class FMPendingServlet
 */
@WebServlet("/fmanager-pending")
public class FMPendingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FMPendingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Reimbursement> list = ReimbursementService.getAllPending();
		String outJSON = "";
		ObjectMapper mapper = new ObjectMapper();

		outJSON = mapper.writeValueAsString(list);
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json");
		writer.write(outJSON);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BufferedReader br = new BufferedReader(
				new InputStreamReader(request.getInputStream()));

		String json = "";
		json = br.readLine();

		ObjectMapper mapper = new ObjectMapper();
		Reimbursement re = mapper.readValue(json, Reimbursement.class);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		re.setReviewer(user.getId());
		ReimbursementService.update(re);
	}

}
