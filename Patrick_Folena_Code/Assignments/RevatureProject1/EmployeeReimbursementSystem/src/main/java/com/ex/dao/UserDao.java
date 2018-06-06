package com.ex.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.User;
import com.ex.util.ConnectionFactory;

public class UserDao implements Dao {

	@Override
	public List<User> getAll() {
		List<User> userList = new ArrayList<User>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			Statement st = conn.createStatement();
			st.execute("SELECT * FROM ERS_USERS");
			ResultSet info = st.getResultSet();
			
			while(info.next())
			{
				User user = new User();
				user.setUserID(info.getInt(1));
				user.setUsername(info.getString(2));
				user.setPassword(info.getString(3));
				user.setFn(info.getString(4));
				user.setLn(info.getString(5));
				user.setEmail(info.getString(6));
				user.setRole(info.getInt(7));
				
				userList.add(user);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public User findOne(Serializable id) {
		User user = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (int)id);
			ResultSet info = ps.executeQuery();
			
			if(!info.next()) return null;
			
			user.setUserID(info.getInt(1));
			user.setUsername(info.getString(2));
			user.setPassword(info.getString(3));
			user.setFn(info.getString(4));
			user.setLn(info.getString(5));
			user.setEmail(info.getString(6));
			user.setRole(info.getInt(7));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User findOneByName(String name)
	{
		User user = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			System.out.println(name);
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet info = ps.executeQuery();
			
			if(!info.next()) return null;
			
			user.setUserID(info.getInt(1));
			user.setUsername(info.getString(2));
			user.setPassword(info.getString(3));
			user.setFn(info.getString(4));
			user.setLn(info.getString(5));
			user.setEmail(info.getString(6));
			user.setRole(info.getInt(7));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User save(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUnique(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
