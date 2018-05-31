package com.proj0.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proj0.pojo.Account;
import com.proj0.pojo.User;
import com.proj0.util.ConnectionFactory;

public class UsersDAO {
	/* Return arraylist of all User in table users */
	public List<User> getAll() {
		ArrayList<User> users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from users";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				User u = new User();
				u.setUserId(rs.getInt(1));
				u.setFirstName(rs.getString(2));
				u.setLastName(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPassword(rs.getString(5));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	/* Insert new account with User object in */
	public boolean insertAccount(User in) {
		boolean ret = false;
		Account a = new Account();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO users (First_name, Last_name, Email, Password) VALUES (?, ?, ?, ?)";
			String[] keys = new String[1];
			keys[0] = "user_id";
			PreparedStatement ps = conn.prepareStatement(sql, keys);

			ps.setString(1,  in.getFirstName());
			ps.setString(2, in.getLastName());
			ps.setString(3,  in.getEmail());
			ps.setString(4, in.getPassword());
			
			int rows = ps.executeUpdate();
			if (rows != 0) {
				ResultSet rs = ps.getGeneratedKeys();
				while (rs.next()) {
					a.setAccountId(rs.getInt(1));
				}
			}
			conn.commit();
			ret = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	// Will check if given email exists compared to all records in database
	public boolean emailExists(String emailIn) {
		boolean emailExists = false;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select email from users where email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emailIn);
			ResultSet rs = ps.executeQuery();
			emailExists = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emailExists;
	}
	/* Returns User account using the given email */
	public User getUserByEmail(String email) {
		User u = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from users where email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			rs.next();
			u.setUserId(rs.getInt(1));
			u.setFirstName(rs.getString(2));
			u.setLastName(rs.getString(3));
			u.setEmail(rs.getString(4));
			u.setPassword(rs.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
}