package com.rev.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rev.pojos.User;
import com.rev.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class UserDAOImpl implements UserDAO{

	@Override
	public ArrayList<User> getAllUsers() {
		ArrayList<User> u = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			//String query = "select * from customer";

			CallableStatement callStmt = conn.prepareCall("{call getusers(?)}");
			callStmt.registerOutParameter(1, OracleTypes.CURSOR);
			//Statement statement = conn.createStatement();
			//ResultSet rs = statement.executeQuery(query);
			callStmt.execute();
			ResultSet rs = (ResultSet) callStmt.getObject(1);
			
			while(rs.next()) {
				User tmp = new User();
				tmp.setUserID(rs.getInt(1));
				tmp.setfName(rs.getString(2));
				tmp.setlName(rs.getString(3));
				//tmp.setUserName(rs.getString(4));
				//tmp.setPassword(rs.getString(5));

				u.add(tmp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}

	@Override
	public void addUser(User u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String query = "insert into customer(FNAME, LNAME, username, password) VALUES(?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, u.getfName());
			ps.setString(2, u.getlName());
			ps.setString(3, u.getUserName().toLowerCase());
			ps.setString(4, u.getPassword());

			int rs = ps.executeUpdate();

			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Boolean findUser(String username) {
		boolean exists = false;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * from CUSTOMER WHERE USERNAME = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username.toLowerCase());			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				exists = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return exists;
	}

	@Override
	public User getUser(String userName) {
		User u = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * from CUSTOMER WHERE USERNAME = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, userName.toLowerCase());			

			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				u.setUserID(rs.getInt(1));
				u.setfName(rs.getString(2));
				u.setlName(rs.getString(3));
				u.setUserName(rs.getString(4));
				u.setPassword(rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return u;
	}

}
