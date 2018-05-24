package com.Banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Banking.pojos.Account;
import com.Banking.pojos.Checking;
import com.Banking.util.ConnectionFactory;

public class CheckingDao implements Dao<Checking, Integer > {


	@Override
	public List<Checking> getAll() {
		ArrayList<Checking> list = new ArrayList<Checking>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from Checking";
			
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(query);
			while(rs.next()) {
				Checking temp = new Checking(rs.getInt(1),rs.getInt(2));
				list.add(temp);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return list;
	}

	@Override
	public Checking findOne(Integer id) {
		Checking a = new Checking();
		try(Connection Conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from checking where accountid = ?";
			PreparedStatement ps = Conn.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
		
			//give out information from rs
			a.setAccountID(id);
			a.setCheckingId(rs.getInt(2));
			a.setBalance(rs.getInt(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Checking save(Checking obj) {
		Checking temp = new Checking(obj.getAccountID(), obj.getBalance());
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String query= "Insert into checking(accountid, balance) "
						+ "values(?,?)";
			String[] keys = new String[1];
			keys[0] = "checkingid";
	
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setInt(1, obj.getAccountID());
			ps.setDouble(2, obj.getBalance());
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					temp.setCheckingId(pk.getInt(1));
				}
			
			
		} 
			
			conn.commit();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return temp;
	}

	@Override
	public void update(Checking obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String query = "update checking set balance = ? where accountid = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, obj.getBalance());
			ps.setInt(2, obj.getAccountID());
			
			ResultSet rs = ps.executeQuery();
			
			conn.commit();
		} catch(SQLException e) {
			
		}
		
	}

	@Override
	public boolean isUnique(Checking obj) {
	boolean isTrue = true;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from checking where accountid = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, obj.getAccountID());
			
			ResultSet rs= ps.executeQuery();
			
			isTrue = rs.next();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return !isTrue;
	}

}
