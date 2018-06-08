package com.Project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Project1.connection.ConnectionFactory;
import com.Project1.pojos.Reimb;
import com.Project1.pojos.User;

public class ReimbDao {

	
	

	public ArrayList<Reimb> getAll() {
		ArrayList<Reimb> reimb = new ArrayList<Reimb>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "Select * from ERS_REIMBURSEMENT";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(query);
			
			while(rs.next()) {
				reimb.add(new Reimb(rs.getInt(1),rs.getDouble(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(7),rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return reimb;
	}


	public Reimb save(Reimb obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			int status = 0;
			String query = "insert into ERS_REIMBURSEMENT (REIMB_AMOUNT ,REIMB_SUBMITTED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID) VALUES (?,SYSDATE,?,?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "Reimb_ID";
			
			PreparedStatement ps = conn.prepareStatement(query);
		
			ps.setDouble(1, obj.getAmount());

			ps.setString(2, obj.getDescription());
			ps.setInt(3, obj.getAuthor());

			ps.setInt(4, status);
			ps.setInt(5, obj.getReimbType());
			
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					obj.setId((pk.getInt(1)));
				}
				
				conn.commit();
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return obj;
	}


	public ArrayList<Reimb> getByID(Integer id) {
		
		ArrayList<Reimb> reimb = new ArrayList<Reimb>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String query = "Select * from ERS_REIMBURSEMENT where REIMB_Author = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			
				reimb.add(new Reimb(rs.getInt(1),rs.getDouble(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(7),rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
			
			
		
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return reimb;
	}

	public void update(Reimb obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String query = "update ERS_REIMBURSEMENT set REIMB_AMOUNT= ?, REIMB_SUBMITTED=?, REIMB_RESOLVED=?, REIMB_DESCRIPTION=?, REIMB_AUTHOR=?, REIMB_RESOLVER=?, REIMB_STATUS_ID=?, REIMB_TYPE_ID=? WHERE REIMB_ID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, obj.getAmount());
			ps.setString(2, obj.getSubmitted());
			ps.setString(3, obj.getResolved());
			ps.setString(4, obj.getDescription());
			ps.setInt(5, obj.getAuthor());	
			ps.setInt(6, obj.getResolver());
			ps.setInt(7, obj.getStatusId());
			ps.setInt(8, obj.getReimbType());
			
			ResultSet rs = ps.executeQuery();
			
			conn.commit();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}





}
