package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jdbc.ConnectionFactory;
import pojo.User;

public class UserDAO {

	public static ArrayList<User> getAll() {
		ArrayList<User> list = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "select * from users";	
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				User temp = new User();
				temp.setId(rs.getInt(1)); //can access by name or index(starts with 1)
				temp.setUsername(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setDefault_account(rs.getInt(4));
				temp.setFirstname(rs.getString(5));
				temp.setLastname(rs.getString(6));
				list.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static User insertUser(int default_account, String...inputs) {
		String username = inputs[0];
		String password = inputs[1];
		String firstname = inputs[2];
		String lastname = inputs[3];
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);

			String[] keys = new String[6];
			keys[0] = "id";
			keys[1] = "username";
			keys[2] = "password";
			keys[3] = "default_account";
			keys[4] = "firstname";
			keys[5] = "lastname";
			
			String query = "insert into users (username, password, default_account, firstname, lastname) values (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, default_account);
			ps.setString(4, firstname);
			ps.setString(5, lastname);
					
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					User temp = new User();
					temp.setId(pk.getInt(1)); //can access by name or index(starts with 1)
					temp.setUsername(pk.getString(2));
					temp.setPassword(pk.getString(3));
					temp.setDefault_account(pk.getInt(4));
					temp.setFirstname(pk.getString(5));
					temp.setLastname(pk.getString(6));
					conn.commit();
					return temp;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getPassword(String username) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select password from users where username = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				return info.getString(1);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static User getByUsername(String username) {	
		User u = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from users where username = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();
			
			while(info.next()) {
				u.setId(info.getInt(1));
				u.setUsername(info.getString(2));
				u.setPassword(info.getString(3));
				u.setDefault_account(info.getInt(4));
				u.setFirstname(info.getString(5));
				u.setLastname(info.getString(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}
}
