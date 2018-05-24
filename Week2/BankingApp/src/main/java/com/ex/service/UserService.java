package com.ex.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ex.dao.BankUserDAO;
import com.ex.dao.DAO;
import com.ex.dao.User_AccountDAO;
import com.ex.pojos.BankUser;
import com.ex.pojos.User_Account;
import com.ex.util.ConnectionFactory;

public class UserService 
{
	static DAO<BankUser, Integer> userdao = new BankUserDAO();
	static DAO<User_Account, Integer> joindao = new User_AccountDAO();
	
	public boolean unique(String un) {
		BankUser dummy = new BankUser();
		dummy.setUsername(un);
		return userdao.isUnique(dummy);
		
	}

	public BankUser addUser(BankUser user) {
		
		return userdao.save(user);
	}

	public BankUser getByUsername(String username) {
		BankUser user = new BankUser();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String sql = "select * from bankuser where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();

			info.next();
			user.setId(info.getInt(1));
			user.setFn(info.getString(2));
			user.setLn(info.getString(3));
			user.setUsername(info.getString(4));
			user.setEmail(info.getString(5));
			user.setPassword(info.getString(6));


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public ArrayList<BankUser> getAllUsers()
	{
		return (ArrayList<BankUser>) userdao.getAll();
	}
	
	public boolean exists(String username)
	{
		ArrayList<BankUser> users = getAllUsers();
		return users.stream().anyMatch(u -> u.getUsername().equals(username));
	}

}
