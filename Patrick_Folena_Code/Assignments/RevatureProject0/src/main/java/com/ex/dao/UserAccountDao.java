package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.ex.pojos.UserAccount;
import com.ex.util.ConnectionFactory;

public class UserAccountDao implements Dao<UserAccount, Integer>{

	public List<UserAccount> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserAccount findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserAccount save(UserAccount obj) {
		int user = obj.getUser().getID();
		int account = obj.getAccount().getID();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "INSERT INTO useraccountlink(accountid, userid) VALUES(?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, account);
			ps.setInt(2, user);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public UserAccount update(UserAccount obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isUnique(UserAccount obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
