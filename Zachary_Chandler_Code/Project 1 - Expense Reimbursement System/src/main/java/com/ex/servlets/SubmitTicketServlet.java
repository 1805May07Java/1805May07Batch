package com.ex.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojo.Ticket;
import com.ex.pojo.User;
import com.ex.service.TicketsService;

@WebServlet("/submitTicket")
public class SubmitTicketServlet extends HttpServlet {

	private static final long serialVersionUID = -3094294999484031722L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = (User) req.getSession().getAttribute("user");
		PrintWriter t = resp.getWriter();
		
		Long amount = null;
		Ticket.Type type = null;
		String desc = null;
		
		BufferedReader r = req.getReader();
		String line;
		
		while((line = r.readLine()) != null) {
			if (line.startsWith("amount:")) {
				try {
					amount = Long.parseLong(line.substring(7));
				} catch (NumberFormatException e) {}
			} else if (line.startsWith("type:")) {
				type = Ticket.Type.valueOf(line.substring(5));
			} else if (line.startsWith("description:")) {
				desc = line.substring(12);
			}
		}
		
		if (u == null || amount == null || type == null) {
			t.write("false");
		} else {
			TicketsService.submitTicket(u, amount, type, desc);
			t.write("submitted");
		}
	}
	
}
