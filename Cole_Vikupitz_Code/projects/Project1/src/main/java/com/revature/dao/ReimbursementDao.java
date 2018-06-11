package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.util.ConnectionFactory;

public class ReimbursementDao {

	public static void addReimbursement(Reimbursement temp) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String query = "{call newRequest(?, ?, ?, ?)}";
			CallableStatement cs = conn.prepareCall(query);
			cs.setDouble(1, temp.getAmount());
			cs.setInt(2, temp.getType());
			cs.setInt(3, temp.getSender());
			cs.setString(4, temp.getDescription());
			// Execute the query
			cs.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Reimbursement> getAllResolved() {

		List<Reimbursement> list = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM Reimbursement WHERE "
					+ "(Status_FK = ? OR Status_FK = ?) "
					+ "ORDER BY ReimbId DESC";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, 2);
			ps.setInt(2, 3);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt(1));
				temp.setAmount(rs.getFloat(2));
				temp.setStatus(rs.getInt(3));
				temp.setType(rs.getInt(4));
				temp.setSender(rs.getInt(5));
				temp.setReviewer(rs.getInt(6));
				temp.setSubmitted(rs.getDate(7).toString());
				temp.setReviewed(rs.getDate(8).toString());
				temp.setDescription(rs.getString(9));
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static List<Reimbursement> getAllPending() {

		List<Reimbursement> list = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM Reimbursement WHERE "
					+ "Status_FK = ? "
					+ "ORDER BY ReimbId DESC";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, 1);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt(1));
				temp.setAmount(rs.getFloat(2));
				temp.setStatus(rs.getInt(3));
				temp.setType(rs.getInt(4));
				temp.setSender(rs.getInt(5));
				//temp.setReviewer(rs.getInt(6));
				temp.setSubmitted(rs.getDate(7).toString());
				//temp.setReviewed(rs.getDate(8).toString());
				temp.setDescription(rs.getString(9));
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}


	public static List<Reimbursement> getAllResolved(int id) {

		List<Reimbursement> list = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM Reimbursement WHERE "
					+ "SubmittedBy_FK = ? AND (Status_FK = ? OR Status_FK = ?) "
					+ "ORDER BY ReimbId DESC";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setInt(2, 2);
			ps.setInt(3, 3);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt(1));
				temp.setAmount(rs.getFloat(2));
				temp.setStatus(rs.getInt(3));
				temp.setType(rs.getInt(4));
				temp.setSender(rs.getInt(5));
				temp.setReviewer(rs.getInt(6));
				temp.setSubmitted(rs.getDate(7).toString());
				temp.setReviewed(rs.getDate(8).toString());
				temp.setDescription(rs.getString(9));
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static List<Reimbursement> getAllPending(int id) {

		List<Reimbursement> list = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM Reimbursement WHERE "
					+ "SubmittedBy_FK = ? AND Status_FK = ? "
					+ "ORDER BY ReimbId DESC";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setInt(2, 1);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt(1));
				temp.setAmount(rs.getFloat(2));
				temp.setStatus(rs.getInt(3));
				temp.setType(rs.getInt(4));
				temp.setSender(rs.getInt(5));
				//temp.setReviewer(rs.getInt(6));
				temp.setSubmitted(rs.getDate(7).toString());
				//temp.setReviewed(rs.getDate(8).toString());
				temp.setDescription(rs.getString(9));
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}


	public static void update(Reimbursement re) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String query = "{call updateRequest(?, ?, ?)}";
			CallableStatement cs = conn.prepareCall(query);
			cs.setInt(1, re.getReviewer());
			cs.setInt(2, re.getStatus());
			cs.setInt(3, re.getId());
			// Execute the query
			cs.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
