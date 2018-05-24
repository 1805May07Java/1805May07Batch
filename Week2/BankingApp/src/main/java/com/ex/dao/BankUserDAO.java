package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.BankAccount;
import com.ex.pojos.BankUser;
import com.ex.util.ConnectionFactory;

public class BankUserDAO implements DAO<BankUser, Integer>
{

	@Override
	public List<BankUser> getAll() {
		List<BankUser> users = new ArrayList<BankUser>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from bankuser";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) { //bankuser: user_id, firstname, lastname, username, email, password 
				BankUser temp = new BankUser();
				temp.setId(rs.getInt(1)); 
				temp.setFn(rs.getString(2));
				temp.setLn(rs.getString(3));
				temp.setUsername(rs.getString(4));
				temp.setEmail(rs.getString(5));
				temp.setPassword(rs.getString(6));
				users.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public BankUser find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankUser save(BankUser obj) {
		BankUser user = new BankUser();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "insert into bankuser(firstname, lastname, username, email, password) "
					+ "values(?, ?, ?, ?, ?)";
			
			String[] keys = new String[1];
			keys[0] = "user_id";
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setString(1, obj.getFn());
			ps.setString(2, obj.getLn());
			ps.setString(3, obj.getUsername());
			ps.setString(4, obj.getEmail());
			ps.setString(5, obj.getPassword());
					
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					user.setId(pk.getInt(1));
				}
				
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public BankUser update(BankUser obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUnique(BankUser obj) 
	{
			String un = obj.getUsername();
			boolean exists = true;
			try(Connection conn = ConnectionFactory.getInstance().getConnection();){
				String query = "select * from bankuser where username = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, un);
				
				ResultSet info = ps.executeQuery();
				exists = info.next();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return !exists;

	}

	
}
