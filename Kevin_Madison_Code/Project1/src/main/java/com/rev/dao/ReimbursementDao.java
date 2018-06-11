package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojo.Reimbursement;
import com.rev.util.ConnectionFactory;

public class ReimbursementDao {
	public List<Reimbursement> getAll() {

		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from ers_reimbursement";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt(1)); 
				temp.setAmount(rs.getInt(2));
				temp.setTimeSubmitted(rs.getString(3));
				temp.setTimeResolved(rs.getString(4));
				temp.setDescription(rs.getString(5));
				temp.setAuthor(rs.getInt(6));
				temp.setResolver(rs.getInt(7));
				temp.setStatusId(rs.getInt(8));
				temp.setTypeId(rs.getInt(9));

				reimbursements.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reimbursements;

	}
	
	//Return the reimbursement based on the reimbursementID
	public Reimbursement getById(int id){
		Reimbursement temp = new Reimbursement();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from ers_reimbursement where reimb_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				temp.setId(rs.getInt(1)); 
				temp.setAmount(rs.getInt(2));
				temp.setTimeSubmitted(rs.getString(3));
				temp.setTimeResolved(rs.getString(4));
				temp.setDescription(rs.getString(5));
				temp.setAuthor(rs.getInt(6));
				temp.setResolver(rs.getInt(7));
				temp.setStatusId(rs.getInt(8));
				temp.setTypeId(rs.getInt(9));

				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return temp;
	}

	//Returns all reimbursements based on the creater's Id
	public List<Reimbursement> getAllById(int id){
		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from ers_reimbursement where reimb_author = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt(1));
				temp.setAmount(rs.getInt(2));
				temp.setTimeSubmitted(rs.getString(3));
				temp.setTimeResolved(rs.getString(4));
				temp.setDescription(rs.getString(5));
				temp.setAuthor(rs.getInt(6));
				temp.setResolver(rs.getInt(7));
				temp.setStatusId(rs.getInt(8));
				temp.setTypeId(rs.getInt(9));

				reimbList.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimbList;
	}
	
	
	public Reimbursement resolveReimbursement(int reimbId, int resolverId, int status) {
		
		Reimbursement temp = new Reimbursement();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String query = "update ers_reimbursement set reimb_resolved = sysdate, reimb_resolver = ?, reimb_status_id = ? where reimb_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, resolverId);
			ps.setInt(2, status);
			ps.setInt(3, reimbId);
			ps.executeUpdate();
			
			
			conn.commit();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//return temp;
		return this.getById(reimbId);
	}

	public void save(Reimbursement obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "insert into ers_reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id) values(?, sysdate, ?, ?, 1, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, obj.getAmount());
			ps.setString(2, obj.getDescription());
			ps.setInt(3, obj.getAuthor());
			ps.setInt(4, obj.getTypeId());
			ps.executeUpdate();
			

			conn.commit();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
