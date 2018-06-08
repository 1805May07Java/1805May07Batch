package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ex.pojos.Reimbursement;
import com.ex.util.ConnectionFactory;

public class ReimbursementDao {

	public ArrayList<Reimbursement> getAll() {
		ArrayList<Reimbursement> data = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select reim.reimb_submitted, u.user_firstname, u.user_lastname, status.reimb_status, typ.reimb_type, " + 
					" reim.reimb_description, reim.reimb_amount, us.user_lastname, " + 
					" reim.reimb_resolved " + 
					"from ers_users u " + 
					"inner join ers_reimbursement reim on u.user_id = reim.reimb_author " + 
					"inner join ers_reimbursement_status status on status.reimb_status_id = reim.reimb_status_id " + 
					"inner join ers_reimbursement_type typ on reim.reimb_type_id = typ.reimb_type_id " + 
					"left outer join ers_users us on reim.reimb_resolver = us.user_id " + 
					"order by reim.reimb_submitted asc";
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement(rs.getDouble(7), rs.getTimestamp(1), rs.getTimestamp(9), rs.getString(6), rs.getString(2), rs.getString(3), rs.getString(8), rs.getString(4), rs.getString(5));
				data.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	public ArrayList<Reimbursement> getById(int id) {
		ArrayList<Reimbursement> data = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select status.reimb_status, typ.reimb_type, reim.reimb_description, " + 
					"reim.reimb_amount, reim.reimb_submitted, us.user_lastname, " + 
					"reim.reimb_resolved " + 
					"from ers_users u " + 
					"inner join ers_reimbursement reim on u.user_id = reim.reimb_author " + 
					"inner join ers_reimbursement_status status on status.reimb_status_id = reim.reimb_status_id " + 
					"inner join ers_reimbursement_type typ on reim.reimb_type_id = typ.reimb_type_id " + 
					"left outer join ers_users us on reim.reimb_resolver = us.user_id " + 
					"where u.user_id = ? " + 
					"order by reim.reimb_submitted desc";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement(rs.getDouble(4), rs.getTimestamp(5), rs.getTimestamp(7), rs.getString(3), rs.getString(6), rs.getString(1), rs.getString(2));
				data.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	public void addReimbursement(int id, double amount, String description, int type_id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "insert into ers_reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id) " + 
					"values(?, current_timestamp, ?, ?, 1, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, amount);
			ps.setString(2, description);
			ps.setInt(3, id);
			ps.setInt(4, type_id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
