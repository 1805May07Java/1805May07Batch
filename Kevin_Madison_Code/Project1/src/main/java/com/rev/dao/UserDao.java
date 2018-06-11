package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojo.User;
import com.rev.util.ConnectionFactory;

public class UserDao {

	public List<User> getAll() {
		
		List<User> Users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from ers_users";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {  
				User temp = new User();
				temp.setUserId(rs.getInt(1)); //can access by name or index(starts with 1)
				temp.setUsername(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setFirstname(rs.getString(4));
				temp.setLastname(rs.getString(5));
				temp.setEmail(rs.getString(6));
				temp.setUserRoleId(rs.getInt(7));
				
				Users.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Users;
		
	}

	public User findOne(Integer id) {
		User obj = new User();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ers_users where ers_user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			info.next();
			obj.setUserId(info.getInt(1));
			obj.setUsername(info.getString(2));
			obj.setPassword(info.getString(3));
			obj.setFirstname(info.getString(4));
			obj.setLastname(info.getString(5));
			obj.setEmail(info.getString(6));
			obj.setUserRoleId(info.getInt(7));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	// adding a new user to the database
	public User save(User obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "insert into ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, obj.getUsername());
			ps.setString(2, obj.getPassword());
			ps.setString(3, obj.getFirstname());
			ps.setString(4,obj.getLastname());
			ps.setString(5,obj.getEmail());
			ps.setInt(6,obj.getUserRoleId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	public User update(User obj) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);

			String query = "update ers_users set ers_username = ?, ers_password = ?, user_first_name = ?, user_last_name = ?, user_email = ? where ers_user_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, obj.getUsername());
			ps.setString(2, obj.getPassword());
			ps.setString(3, obj.getFirstname());
			ps.setString(4, obj.getLastname());
			ps.setString(5, obj.getEmail());
			ps.setInt(6, obj.getUserId());

			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;

	}

	public boolean isUnique(User obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// returns true if the password is correct
	public boolean login(String username, String password) {
		System.out.println("in user dao login method");
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);

			String query = "select ers_password from ers_users where ers_username = ?";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String temp = rs.getString(1);
			if(temp.equals(password)) {
				System.out.println("true");
				return true;
			}else {
				System.out.println("fa;se");
				return false;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;

	}

	public User getUserByName(String username) {
		User obj = new User();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);

			String query = "select * from ers_users where ers_username = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();
			
			info.next();
			
			obj.setUserId(info.getInt(1));
			obj.setUsername(info.getString(2));
			obj.setPassword(info.getString(3));
			obj.setFirstname(info.getString(4));
			obj.setLastname(info.getString(5));
			obj.setEmail(info.getString(6));
			obj.setUserRoleId(info.getInt(7));
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

}

