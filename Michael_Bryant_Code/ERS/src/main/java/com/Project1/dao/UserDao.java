package com.Project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Project1.connection.ConnectionFactory;
import com.Project1.pojos.User;

public class UserDao {
	
	ArrayList<User> users = new ArrayList<User>();


	public ArrayList<User> getAll() {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "Select * from ERS_USERS";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(query);
			
			while(rs.next()) {
				users.add(new User(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return users;
	}


	public User save(User obj) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
		conn.setAutoCommit(false);
		String query = "insert into ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER,ROLE,ID) VALUES (?,?,?,?,?,?)";
		
		String[] keys = new String[1];
		keys[0] = "ERS_USERS_ID";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, obj.getUsername());
		ps.setString(2, obj.getPassword());
		ps.setString(3, obj.getFirstName());
		ps.setString(4, obj.getLastName());
		ps.setString(5, obj.getEmail());
		ps.setInt(6, obj.getUserRoleId());
		
		int rows = ps.executeUpdate();
		
		if(rows != 0) {
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()) {
				obj.setUserId(pk.getInt(1));
			}
			
			conn.commit();
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}


	public User getByID(Integer id) {
		User u = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "Select * from ERS_USERS where ERS_USERS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			info.next();
			u.setUserId(id);
			u.setUsername(info.getString(2));
			u.setPassword(info.getString(3));
			u.setFirstName(info.getString(4));
			u.setLastName(info.getString(5));
			u.setEmail(info.getString(6));
			u.setUserRoleId(info.getInt(7));

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return u;
	}


	public void update(User obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String query = "update ERS_Users set ERS_USERNAME = ?, ERS_PASSWORD = ?, USER_FIRST_NAME = ?, USER_LAST_NAME = ?, USER_EMAIL = ?, USER_ROLE_ID = ? WHERE ERS_USERS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, obj.getUsername());
			ps.setString(2, obj.getPassword());
			ps.setString(3, obj.getFirstName());
			ps.setString(4, obj.getLastName());
			ps.setString(5, obj.getEmail());
			ps.setInt(6, obj.getUserRoleId());
			
			ResultSet rs = ps.executeQuery();
			
			conn.commit();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	public boolean isUnique(User obj) {
		boolean isTrue = true;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from ERS_USERS where ERS_USERS_ID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, obj.getUserId());
			
			ResultSet rs= ps.executeQuery();
			
			isTrue = rs.next();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return !isTrue;
	}

}
