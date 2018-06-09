package com.rev.pojos;

public class K {
	private int ticketID;

	public K() {
		super();
		// TODO Auto-generated constructor stub
	}

	public K(int ticketID) {
		this.ticketID = ticketID;
	}

	@Override
	public String toString() {
		return "K [ticketID=" + ticketID + "]";
	}

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	
	
}
