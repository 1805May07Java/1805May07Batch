package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.ex.pojo.Ticket;
import com.ex.pojo.User;
import com.ex.service.TicketsService;

@WebServlet("/getTicket")
public class GetTicketServlet extends HttpServlet {

	private static final long serialVersionUID = 2261820759317834029L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = (User) req.getSession().getAttribute("user");
		PrintWriter t = resp.getWriter();
		Long id;
		
		try {
			id = Long.parseLong(req.getParameter("id"));
		} catch(NumberFormatException e) {
			id = null;
		}

		resp.setContentType("application/json");
		if (id == null || u == null) {
			t.write("null");
		} else {
			Ticket ticket = TicketsService.getTicket(u, id);
			t.write(ticket != null?new JSONObject(ticket).toString():"null");
		}
	}
	
}
