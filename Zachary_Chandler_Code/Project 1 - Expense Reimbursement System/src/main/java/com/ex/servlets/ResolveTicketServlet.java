package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojo.Ticket.Status;
import com.ex.pojo.User;
import com.ex.service.TicketsService;

@WebServlet("/resolveTicket")
public class ResolveTicketServlet extends HttpServlet {

	private static final long serialVersionUID = 1868986359516483754L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User u = (User) req.getSession().getAttribute("user");
		PrintWriter t = resp.getWriter();
		boolean approve = req.getParameter("approve") != null;
		boolean deny = req.getParameter("deny") != null;
		Long id;
		
		try {
			id = Long.parseLong(req.getParameter("id"));
		} catch(NumberFormatException e) {
			id = null;
		}

		resp.setContentType("application/json");
		if (id == null || u == null || u.getRole() != User.Role.FinanceManager || u.getRole() != User.Role.FinanceManager || (!approve && !deny)) {
			t.write("false");
		} else {
			Status s = approve ? Status.Approved : Status.Denied;
			t.write(Boolean.toString(TicketsService.resolve(u, TicketsService.getTicket(u, id), s)));
		}
	}
}
