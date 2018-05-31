package com.ex.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ex.pojo.Ticket;
import com.ex.pojo.User;
import com.ex.pojo.Ticket.Status;
import com.ex.pojo.Ticket.Type;
import com.ex.utility.ConnectionFactory;

public class TicketsDAOImpl implements TicketsDAO {

	@Override
	public void addTicket(long amount, String description, User author, Type type) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			PreparedStatement st = conn.prepareStatement("insert into ers_reimbursement "
					+ "(reimb_id,  reimb_ammount, reimb_description, reimb_submitted, reimb_author, reimb_status_id, reimb_type_id)"
					+ "values (default, ?, ?, default, ?, 0, ?)");
			
			st.setLong(1, amount);
			st.setString(2, description);
			st.setLong(3, author.getId());
			st.setInt(4, type.value);
			st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Ticket> getTickets(User user) {

		List<Ticket> tickets = new LinkedList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			PreparedStatement st = conn.prepareStatement("select * from ers_reimbursement where reimb_author=?");
			st.setLong(1, user.getId());
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				tickets.add(getTicket(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			tickets = new LinkedList<>();
		}
		
		return tickets;
	}

	@Override
	public List<Ticket> getTickets() {
		
		List<Ticket> tickets = new LinkedList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			
//			CallableStatement st = conn.prepareCall("select * from ers_reimbursement");
			PreparedStatement st = conn.prepareStatement("select * from ers_reimbursement");
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				tickets.add(getTicket(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			tickets = new LinkedList<>();
		}
		
		return tickets;
	}

	@Override
	public List<Ticket> getTickets(Status status) {
		
		List<Ticket> tickets = new LinkedList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			PreparedStatement st = conn.prepareStatement("select * from ers_reimbursement where reimb_status_id=?");
			st.setLong(1, status.value);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				tickets.add(getTicket(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			tickets = new LinkedList<>();
		}
		
		return tickets;
	}

	@Override
	public void resolve(Ticket ticket, User resolver, Status status) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			PreparedStatement st = conn.prepareStatement("update ers_reimbursement "
					+ "set reimb_status_id = ?, reimb_resolver = ?, reimb_resolved = ?"
					+ "where reimb_id = ?");
			
			Date d = new Date(System.currentTimeMillis());
			
			st.setInt(1, status.value);
			st.setLong(2, resolver.getId());
			st.setDate(3, d);
			st.setLong(4, ticket.getId());
			st.executeUpdate();
			
			ticket.setStatus(status);
			ticket.setResolver(resolver);
			ticket.setResolved(d);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Ticket getTicket(Long id) {

		Ticket t = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {

			PreparedStatement st = conn.prepareStatement("select * from ers_reimbursement where reimb_id=?");
			st.setLong(1, id);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				t = getTicket(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			t = null;
		}
		
		return t;
	}
	
	public static Ticket getTicket(ResultSet rs) throws SQLException {
		Ticket t = new Ticket();

		t.setId(rs.getLong(1));
		t.setAmmount(rs.getLong(2));
		t.setSubmitted(rs.getDate(3));
		t.setResolved(rs.getDate(4));
		t.setDescription(rs.getString(5));

		long user = rs.getLong(7);
		
		if (user != 0) {
			t.setAuthor(new UserDAOImpl().get(user));
		}
		
		user = rs.getLong(8);
		
		if (user != 0) {
			t.setResolver(new UserDAOImpl().get(user));
		}
		
		t.setStatus(Ticket.Status.translate(rs.getInt(9)));
		t.setType(Type.translate(rs.getInt(10)));
		
		return t;
	}
}
