package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ex.pojos.User;
import com.ex.util.ConnectionFactory;

import oracle.net.ns.NetException;

public class UserDao implements Dao<User, String>{

	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User findOne(String id) {
		User user = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM userlist WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet info = ps.executeQuery();
			
			if(!info.next()) return null;
			
			user.setID(info.getInt(1));
			user.setUsername(info.getString(2));
			user.setPassword(info.getString(3));
			user.setFirstname(info.getString(4));
			user.setLastname(info.getString(5));
			user.setEmail(info.getString(6));
		}  catch (SQLException e) {
				e.printStackTrace();
		}
		
		return user;
	}

	public User save(User obj) {
		User user = new User();
		user.setEmail(obj.getEmail());
		user.setFirstname(obj.getFirstname());
		user.setLastname(obj.getLastname());
		user.setPassword(obj.getPassword());
		user.setUsername(obj.getUsername());
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO userlist(username, password, firstname, lastname, email)"
					+ "values(?,?,?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "userid";
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, obj.getUsername());
			ps.setString(2, obj.getPassword());
			ps.setString(3, obj.getFirstname());
			ps.setString(4, obj.getLastname());
			ps.setString(5, obj.getEmail());
			
			int rows = ps.executeUpdate();
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					user.setID(pk.getInt(1));
				}
				conn.commit();
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		};	
		return user;
	}
	
	public User update(User obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String query = "update userlist set username = ?, "
					+ "password = ?, "
					+ "firstname=?, "
					+ "lastname=?, "
					+ "email=? "
					+ "where userid=?";
						
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, obj.getUsername());
			ps.setString(2, obj.getPassword());
			ps.setString(3, obj.getFirstname());
			ps.setString(4, obj.getLastname());
			ps.setString(5, obj.getEmail());
			ps.setInt(6, obj.getID());
			
			ps.executeUpdate();
			System.out.println(obj.getID());
			conn.commit();
		}  catch (SQLException e) {
			e.printStackTrace();
		};	
		return obj;
	}

	public boolean isUnique(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
