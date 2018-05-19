package com.ex.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ex.POJO.User;
import com.ex.UTIL.ConnectionFactory;

public class UserDAOimp implements UserDAO {

	@Override
	public ArrayList<User> getAllStoredUsers() {
		ArrayList<User> Users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String query = "select * from Users";
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				User temp = new User();
				temp.setUserID(rs.getInt("UserID"));
				temp.setIsAdmin(rs.getInt(2));
				temp.setEmail(rs.getString(3));
				temp.setFirstName(rs.getString(4));
				temp.setLastName(rs.getString(5));
				temp.setPassword(rs.getString(6));
				
				Users.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Users;
	}

	@Override
	public User getById(int id) {
		User user = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from Users where Userid = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user.setUserID(rs.getInt("UserID"));
				user.setEmail(rs.getString(2));
				user.setFirstName(rs.getString(3));
				user.setLastName(rs.getString(4));
				user.setPassword(rs.getString(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public User addUser(String email, String fName, String lName, String pass) {
		User user = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "insert into User (email, firstname, lastname,password) values (?,?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "Userid";
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setString(1, email);
			ps.setString(2, fName);
			ps.setString(3, lName);
			ps.setString(4, pass);
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					user.setUserID(pk.getInt(1));
					user.setEmail(pk.getString(2));
					user.setFirstName(pk.getString(3));
					user.setLastName(pk.getString(4));
					user.setPassword(pk.getString(5));
					
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return user;
	}
	
	@Override
	public User removeUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateUserFirstName(int id, String newFname) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "update User set name = ? where Userid = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, newFname);
			ps.setInt(2, id);
		System.out.println( ps.executeUpdate()) ;
		//	System.out.println(row + "rows affected");
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

	@Override
	public void updateUserLastName(int id, String newLname) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "update User set name = ? where Userid = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, newLname);
			ps.setInt(2, id);
		System.out.println( ps.executeUpdate()) ;
		//	System.out.println(row + "rows affected");
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateUserEmail(int id, String newEmail) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "update User set name = ? where Userid = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, newEmail);
			ps.setInt(2, id);
		System.out.println( ps.executeUpdate()) ;
		//	System.out.println(row + "rows affected");
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateUserPassword(int id, String newPass) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "update User set name = ? where Userid = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, newPass);
			ps.setInt(2, id);
		System.out.println( ps.executeUpdate()) ;
		//	System.out.println(row + "rows affected");
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
