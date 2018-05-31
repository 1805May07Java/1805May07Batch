package com.ex.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.ex.dao.TicketsDAO;
import com.ex.dao.TicketsDAOImpl;
import com.ex.pojo.Ticket;
import com.ex.pojo.Ticket.Status;
import com.ex.pojo.Ticket.Type;
import com.ex.servlets.LoginServlet;
import com.ex.pojo.User;

public class TicketsService {

	private static TicketsDAO dao = new TicketsDAOImpl();
	final static Logger logger = Logger.getLogger(LoginServlet.class);
	
	public static List<Ticket> getEmployeeTickets(User u) {
		logger.info(String.format("%S has polled their tickets.", u.getUsername()));
		return dao.getTickets(u);
	}

	public static List<Ticket> getAllTickets(User u) {
		logger.info(String.format("%S has polled all tickets.", u.getUsername()));
		return dao.getTickets();
	}

	public static void submitTicket(User u, Long amount, Type type, String desc) {
		logger.info(String.format("%S has submitted a ticket.", u.getUsername()));
		dao.addTicket(amount, desc, u, type);
	}

	public static Ticket getTicket(User u, Long id) {
		Ticket ticket = dao.getTicket(id);
		
		if (u.getRole() != User.Role.FinanceManager && ticket.getAuthor().getId() != u.getId()) {
			ticket = null;
		}
		
		logger.info(String.format("%S has attempted to poll a ticket, ID:%s.", u.getUsername(), Long.toString(id)));
		return ticket;
	}

	public static boolean resolve(User u, Ticket ticket, Ticket.Status status) {
		if (u == null || ticket == null || u.getRole() != User.Role.FinanceManager || ticket.getStatus() != Status.Pending) {
			return false;
		}

		logger.info(String.format("%S has resolved a ticket, ID:%s.", u.getUsername(), Long.toString(ticket.getId())));
		dao.resolve(ticket, u, status);
		return true;
	}

}
