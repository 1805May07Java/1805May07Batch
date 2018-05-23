package com.ex.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ex.POJO.Account;
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
				temp.setUserID(rs.getInt("User_ID"));
				temp.setIsAdmin(rs.getInt(2)==1);
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
			String query = "select * from Users where User_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user.setUserID(rs.getInt("User_ID"));
				user.setIsAdmin(rs.getInt(2)==1);
				user.setEmail(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setPassword(rs.getString(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		user.setAccounts(getUserAccounts(user.getUserID()));
		
		return user;
	}
	
	@Override
	public User getByEmail(String email) {
		User user = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from Users where email = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user.setUserID(rs.getInt("User_ID"));
				user.setIsAdmin(rs.getInt(2)==1);
				user.setEmail(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setPassword(rs.getString(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		user.setAccounts(getUserAccounts(user.getUserID()));
		
		return user;
	}

	@Override
	public User addUser(String email, String fName, String lName, String pass) {
		User user = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "call new_user(?, ?, ?, ?)";
			
			String[] keys = new String[1];
			keys[0] = "User_id";
			
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
				}
				user.setEmail(email);
				user.setFirstName(fName);
				user.setLastName(lName);
				user.setPassword(pass);
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return user;
	}
	
	@Override
	public void removeUser(int id) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "delete from users where user_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean checkUserEmail(String email) {
		boolean doesContain = false;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select count(1) from Users where email = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			rs.next();
			doesContain = (rs.getInt(1) == 1);			//if the email exists already, rs should return 1, else 0
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return doesContain;
	}
	
	@Override
	public boolean checkUserID(int id) {
		boolean doesContain = false;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select count(1) from Users where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			doesContain = (rs.getInt(1) == 1);			//if the email exists already, rs should return 1, else 0
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return doesContain;
	}
	
	@Override
	public boolean checkUserPassword(int id, String pass) {
		boolean correctPass = false;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select count(1) from Users where user_id = ? and pass = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			rs.next();
			correctPass = (rs.getInt(1) == 1);			//if the email exists already, rs should return 1, else 0
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return correctPass;
	}

	
	@Override
	public boolean checkIsAdmin(int id) {
		boolean doesContain = false;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select is_admin from USERS where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			doesContain = (rs.getInt(1) == 1);			//if the email exists already, rs should return 1, else 0
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return doesContain;
	}



	@Override
	public void updateUserFirstName(int id, String newFname) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "update Users set name = ? where User_id = ?";
			
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
			String query = "update Users set name = ? where User_id = ?";
			
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
			String query = "update Users set name = ? where User_id = ?";
			
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
			String query = "update Users set name = ? where User_id = ?";
			
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

	//get all account numbers TODO get accounts from those numbers
	@Override
	public ArrayList<Account> getUserAccounts(int id) {
		ArrayList<Account> accounts = new ArrayList<Account>();
		Account temp = new Account();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from accounts_users where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				//query accounts with account number
				int accNo = rs.getInt(2);
				try(Connection conn2 = ConnectionFactory.getInstance().getConnection()){
					String query2 = "select * from accounts where acc_id = ?";
					PreparedStatement ps2 = conn.prepareStatement(query2);
					ps2.setInt(1, accNo);
					ResultSet rs2 = ps2.executeQuery();
					while(rs2.next()) {
						temp.setAccountNumber(rs2.getInt(1));
						temp.setAccType(rs2.getInt(2));;
						temp.setBalance(rs2.getDouble(3));
						accounts.add(temp);
						temp = new Account();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accounts;
	}

	@Override
	public void makeAdmin(int id) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "update Users set is_Admin = 1 where user_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
		System.out.println( ps.executeUpdate()) ;
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Integer> getUserAccountNumbers(int id) {
		ArrayList<Integer> accNumbers = new ArrayList<Integer>();
		for (Account a : getUserAccounts(id)) {
			accNumbers.add(a.getAccountNumber());
		}
		return accNumbers;
	}

	
	
	

}
