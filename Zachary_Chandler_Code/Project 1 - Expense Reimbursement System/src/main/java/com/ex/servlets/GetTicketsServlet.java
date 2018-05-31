package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONStringer;

import com.ex.pojo.User;
import com.ex.service.TicketsService;

@WebServlet("/getTickets")
public class GetTicketsServlet extends HttpServlet {

	private static final long serialVersionUID = 4815544854913457195L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = (User) req.getSession().getAttribute("user");
		PrintWriter t = resp.getWriter();
		resp.setContentType("application/json");
		
		if (u == null) {
			t.write("[]");
		} else if (u.getRole() == User.Role.Employee) {
			t.write(JSONStringer.valueToString(TicketsService.getEmployeeTickets(u)));
		} else if (u.getRole() == User.Role.FinanceManager) {
			t.write(JSONStringer.valueToString(TicketsService.getAllTickets(u)));
		}
		
	}
}
