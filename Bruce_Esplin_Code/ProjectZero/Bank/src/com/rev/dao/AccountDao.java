package com.rev.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Account;
import com.rev.util.ConnectionFactory;

public class AccountDao{ 
	
	public static List<Account> getAll() {
					
			List<Account> Accounts = new ArrayList<Account>();
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				String query = "select * from Account";

				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(query);
				
				while(rs.next()) { //Account: Account_id, username
					Account temp = new Account();
					temp.setId(rs.getInt(1)); //can access by name or index(starts with 1)
					temp.setUsername(rs.getString(2));
					Accounts.add(temp);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return Accounts;
			
		}
	
	public Account getBalance(int id) {
		
			Account account = new Account();

			try(Connection conn = ConnectionFactory.getInstance().getConnection()){

				String sql = "select acc_bal from account where cust_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet info = ps.executeQuery();

				info.next();
				account.setId(info.getInt(1));
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return account;
		}
	
	public Account addAccount(Account obj) {
		
			Account account = new Account();
			
			try(Connection conn = ConnectionFactory.getInstance().getConnection();){
				conn.setAutoCommit(false);
				String query = "insert into account(acc_id, username, acc_type, acc_bal)"
						+ "values(?, ?, ?, ?)";
				
				String[] keys = new String[1];
				keys[0] = "acc_id";
				
				PreparedStatement ps = conn.prepareStatement(query, keys);
				ps.setInt(1, obj.getId());
				ps.setString(2, obj.getUsername());
				ps.setInt(3, obj.getType());
				ps.setDouble(4, obj.getBalance());
				
				int rows = ps.executeUpdate();
				
				if(rows != 0) {
					ResultSet pk = ps.getGeneratedKeys();
					while(pk.next()) {
						account.setId(pk.getInt(1));
					}
					
					conn.commit();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return account;
		}

	boolean isUnique(Account obj) {
		// TODO Auto-generated method stub
		return false;
	
}}


