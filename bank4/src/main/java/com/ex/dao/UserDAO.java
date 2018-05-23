package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import com.ex.pojo.User;
import com.ex.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class UserDAO {
	public void save(User user) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "insert into Users values(?,?,?,?,?)";
						
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getUserId().toString());
			ps.setString(2, user.getUname());
			ps.setString(3, user.getPwd());
			ps.setString(4, user.getFname());
			ps.setString(5, user.getLname());
			
			ps.executeQuery();
			conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public boolean confirmLogin(String uname, String pwd) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "select * from Users where uname = ? and pwd = ?";
						
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			
			ResultSet rs = ps.executeQuery();
			conn.commit();
			return rs.next();
			//UUID userid = (UUID) rs.getObject(1); //possible problem
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}
	
	public UUID getUserId(String uname, String pwd) {
		UUID userid = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "select * from Users where uname = ? and pwd = ?";
						
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			
			ResultSet rs = ps.executeQuery();
			rs.next(); //not sure why
			conn.commit();
			userid = UUID.fromString(rs.getObject(1).toString()); //possible problem
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return userid;

	}
	
	public ArrayList<User> getAllUsers() {
		ArrayList<users> users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "{call (?) }";
			
			CallableStatement cs = conn.prepareCall(query);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
}
}
