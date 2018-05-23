package com.ex.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.ex.pojo.Account;
import com.ex.util.ConnectionFactory;

public class AccountDAO {
	public void save(Account account) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "insert into Accounts values(?,?,?)";
						
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, account.getAccountid().toString());
			ps.setString(2, account.getAccounttype());
			ps.setDouble(3, account.getBalance());
			
			ps.executeQuery();
			conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public double getBalance(UUID accountid) {
		double bal = 123.45;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "select * from Accounts where accountid = ?";
						
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, accountid.toString());
			
			ResultSet rs = ps.executeQuery();
			rs.next(); //not sure why
			conn.commit();
			bal = rs.getDouble(3);
			//userid = UUID.fromString(rs.getObject(1).toString()); //possible problem
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return bal;
	}
	
	public void deposit(UUID accountid, double amount) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "select * from Accounts where accountid = ?";
						
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, accountid.toString());
			
			ResultSet rs = ps.executeQuery();
			rs.next(); //not sure why
		//	conn.commit();
			String type = rs.getString(2);
			double bal = rs.getDouble(3);
			
			bal += amount;
			
			String query2 = "update Accounts set balance = ? where accountid = ?";
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ps2.setDouble(1, bal);
			ps2.setString(2, accountid.toString());
			ps2.executeQuery();
			//userid = UUID.fromString(rs.getObject(1).toString()); //possible problem
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
}
