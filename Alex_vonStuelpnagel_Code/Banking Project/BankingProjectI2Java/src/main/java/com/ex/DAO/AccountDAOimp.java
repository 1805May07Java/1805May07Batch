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

public class AccountDAOimp implements AccountDAO {

	@Override
	public ArrayList<Account> getAllStoredAccounts() {
		ArrayList<Account> Accounts = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String query = "select * from Accounts";
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Account temp = new Account();
				temp.setAccountNumber(rs.getInt("AccType"));
				temp.setAccType(rs.getInt(2));
				temp.setBalance(rs.getDouble(3));
				
				Accounts.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Accounts;
	}

	@Override
	public Account getById(int id) {
		Account acc = new Account();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from Accounts where AccID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				acc.setAccountNumber(rs.getInt("AccType"));
				acc.setAccType(rs.getInt(2));
				acc.setBalance(rs.getDouble(3));

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return acc;
	}

	@Override
	public Account addAccount(int accountType) {
		Account acc = new Account();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "insert into Accounts (accType, balance) values (?,?)";
			
			String[] keys = new String[1];
			keys[0] = "Userid";
			
			PreparedStatement ps = conn.prepareStatement(query, keys);
			ps.setInt(1, accountType);

			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					acc.setAccountNumber(pk.getInt("AccType"));
					acc.setAccType(pk.getInt(2));
					acc.setBalance(pk.getDouble(3));
					
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return acc;
	}

	@Override
	public void removeAccount(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAccountBalance(int id, int newBalance) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "update Accounts set name = ? where Accountid = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, newBalance);
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
	public void addAccountOwner(int id, int userID) {
		// TODO Auto-generated method stub
		
	}

}
