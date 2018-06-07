package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ex.pojo.User;
import com.ex.utility.ConnectionFactory;

public class UserDAOImpl implements UserDAO {

	@Override
	public User login(String username, String password) {
		User user = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			CallableStatement st = conn.prepareCall("{call checkUserCredentials(?, ?, ?)}");
			st.setString(1, username);
			st.setString(2, password);
			st.registerOutParameter(3, java.sql.Types.NUMERIC);
			st.executeQuery();

			if (st.getLong(3) != 0) {
				user = get(username);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			user = null;
		}
		
		return user;
	}
	
	@Override
	public User get(String username) {

		User user = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			PreparedStatement st = conn.prepareStatement("select * from ers_users where ers_username=?");
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				user = loadUser(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			user = null;
		}
		
		return user;
	}

	@Override
	public User get(long userID) {

		User user = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			PreparedStatement st = conn.prepareStatement("select * from ers_users where ers_users_id=?");
			st.setLong(1, userID);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				user = loadUser(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			user = null;
		}
		
		return user;
	}

	public User get(long userID, Connection conn) {

		User user = null;
		
		try {
			
			PreparedStatement st = conn.prepareStatement("select * from ers_users where ers_users_id=?");
			st.setLong(1, userID);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				user = loadUser(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			user = null;
		}
		
		return user;
	}

	private User loadUser(ResultSet rs) throws SQLException {
		User user = new User();
		
		user.setId(rs.getLong(1));
		user.setUsername(rs.getString(2));
		user.setPassword(null);
		user.setFirstName(rs.getString(4));
		user.setLastName(rs.getString(5));
		user.setEmail(rs.getString(6));
		user.setRole(User.Role.translate(rs.getInt(7)));
		
		return user;
	}



}
