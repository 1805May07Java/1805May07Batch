package com.ex.dao;

import java.util.List;

import com.ex.pojo.Ticket;
import com.ex.pojo.User;

public interface TicketsDAO {

	public void addTicket(long amount, String description, User author, Ticket.Type type);
	
	public List<Ticket> getTickets(User user);
	public List<Ticket> getTickets();
	public List<Ticket> getTickets(Ticket.Status status);
	
	public void resolve(Ticket ticket, User resolver, Ticket.Status status);

	public Ticket getTicket(Long id);
}
