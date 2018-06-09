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

public class UserDAOImpl implements UserDAO {

	@Override
	public ArrayList<User> getAllUsers() {
		ArrayList<User> u = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			CallableStatement callStmt = conn.prepareCall("{call getusers(?)}");
			callStmt.registerOutParameter(1, OracleTypes.CURSOR);

			callStmt.execute();
			ResultSet rs = (ResultSet) callStmt.getObject(1);

			while(rs.next()) {
				User tmp = new User(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));

				u.add(tmp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public User addUser(User u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String query = "INSERT INTO ERS_Users(ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)" + 
					"VALUES(?, ?, ?, ?, ?, ?)";
			System.out.println(u.getRole());
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, u.getUserName().toLowerCase());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getfName());
			ps.setString(4, u.getlName());
			ps.setString(5, u.getEmail().toLowerCase());
			ps.setInt(6, u.getRole());

			int rs = ps.executeUpdate();
			
			if(rs > 0) {
				conn.commit();
				query = "SELECT ERS_USERS_ID FROM ERS_Users WHERE ERS_USERNAME=?";
				PreparedStatement ps2 = conn.prepareStatement(query);
				ps2.setString(1, u.getUserName().toLowerCase());
				u.setUserID(ps2.executeUpdate());
			}
			else {
				u = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			u = null;
		}

		return u;
	}

	@Override
	public User getUser(String userName) {
		User u = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "Select * from ERS_Users WHERE ERS_USERNAME = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, userName.toLowerCase());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public User getUser(int userId) {
		User u = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "Select * from ERS_Users WHERE ERS_USERS_ID = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}

	@Override
	public boolean updateUser(User u) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String query = "UPDATE ERS_Users SET ERS_USERNAME = ?, ERS_PASSWORD = ?, USER_FIRST_NAME = ?, USER_LAST_NAME = ?, USER_EMAIL = ? WHERE  ERS_USERS_ID = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, u.getUserName().toLowerCase());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getfName());
			ps.setString(4, u.getlName());
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getUserID());

			int rs = ps.executeUpdate();

			conn.commit();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String getRole(int userId) {
		String r = "";
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "SELECT USER_ROLE" + 
					"FROM ERS_USER_ROLES" + 
					"inner JOIN ERS_USERS" + 
					"on ERS_USER_ROLES.ERS_USER_ROLE_ID = ERS_USERS.USER_ROLE_ID" + 
					"WHERE ERS_USERS.ERS_USERS_ID = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			r = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

}
