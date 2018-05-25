package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ex.pojo.User;
import com.ex.util.ConnectionFactory;

public class UserDao {

	public ArrayList<User> getAll() {
		ArrayList<User> users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String query = "select * from bankuser";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				User temp = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				users.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public User getByUsername(String un) {
		User user = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from bankuser where username = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, un);
			ResultSet rs = ps.executeQuery();

			rs.next();
			user.setId(rs.getInt(1));
			user.setFirstname(rs.getString(2));
			user.setLastname(rs.getString(3));
			user.setUsername(rs.getString(4));
			user.setPassword(rs.getString(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return user;
	}

	public int isTaken(String un) {
		int ret = 0;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select count(*) from bankuser where username = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, un);
			ResultSet rs = ps.executeQuery();

			rs.next();
			ret = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public void addUser(String fn, String ln, String un, String pw) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "insert into bankuser(firstname, lastname, username, credential) "
					+ "values(?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, un);
			ps.setString(4, pw);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int validUnPw(String un, String pw) {
		int ret = 0;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select count(*) from bankuser where username = ? and credential = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, un);
			ps.setString(2, pw);
			ResultSet rs = ps.executeQuery();

			rs.next();
			ret = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public int findIdByUsername(String un) {
		int ret = 0;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select user_id from bankuser where username = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, un);
			ResultSet rs = ps.executeQuery();

			rs.next();
			ret = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public void updatePw(int id, String pw) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "{call update_user_pw(?, ?)}";

			CallableStatement cs = conn.prepareCall(query);
			cs.setInt(1, id);
			cs.setString(2, pw);

			cs.execute();


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
