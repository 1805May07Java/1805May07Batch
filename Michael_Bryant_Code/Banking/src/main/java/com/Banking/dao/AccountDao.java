package com.Banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Banking.pojos.Account;
import com.Banking.util.ConnectionFactory;

public class AccountDao implements Dao<Account, Integer> {
	

	@Override
	public List<Account> getAll() {
		ArrayList<Account> list = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from accounts";
			
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(query);
			while(rs.next()) {
				Account temp = new Account(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4));
				list.add(temp);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return list;
	}

	@Override
	public Account save(Account obj) {
		Account temp = new Account(obj.getUser(), obj.getPass(), obj.getEmail());
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			
			String query= "Insert into Accounts(username, password, email) "
						+ "values(?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "accountid";
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setString(1, obj.getUser());
			ps.setString(2, obj.getPass());
			ps.setString(3, obj.getEmail());
			
				int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					temp.setAccountid(pk.getInt(1));
				}
			
			conn.commit();
		} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return temp;
		
	}

	@Override
	public void update(Account obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String query = "update accounts set username = ?, password = ?, email = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, obj.getUser());
			ps.setString(2, obj.getPass());
			ps.setString(3, obj.getEmail());
			
			ResultSet rs = ps.executeQuery();
			
			conn.commit();
		} catch(SQLException e) {
			
		}
		
	}

	@Override
	public boolean isUnique(Account obj) {
		boolean isTrue = true;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from accounts where username = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, obj.getUser());
			
			ResultSet rs= ps.executeQuery();
			
			isTrue = rs.next();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return !isTrue;
	}

	@Override
	public Account findOne(Integer id) {
		Account a = new Account();
		try(Connection Conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from accounts where accountid = ?";
			PreparedStatement ps = Conn.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
		
			//give out information from rs
			a.setAccountid(rs.getInt(1));
			a.setUser(rs.getString(2));
			a.setPass(rs.getString(3));
			a.setEmail(rs.getString(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

}
