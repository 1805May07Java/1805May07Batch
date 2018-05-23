package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.ex.pojo.Account;
import com.ex.pojo.Account_User;
import com.ex.util.ConnectionFactory;

public class Account_UserDAO {
		
		public void save(Account_User au) {
			try(Connection conn = ConnectionFactory.getInstance().getConnection();){
				conn.setAutoCommit(false);
				String query = "insert into Accounts_Users values(?,?)";
							
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, au.getAccountid().toString());
				ps.setString(2, au.getUserId().toString());
							
				ps.executeQuery();
				conn.commit();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		public UUID getAccountId(UUID userid) {
			UUID accountid = null;
			try(Connection conn = ConnectionFactory.getInstance().getConnection();){
				conn.setAutoCommit(false);
				String query = "select * from accounts_users where userid = ?";
							
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, userid.toString());
							
				ResultSet rs = ps.executeQuery();
				conn.commit();
				rs.next();
				accountid= UUID.fromString(rs.getObject(1).toString()); //possible problem
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			return accountid;
		}
}
