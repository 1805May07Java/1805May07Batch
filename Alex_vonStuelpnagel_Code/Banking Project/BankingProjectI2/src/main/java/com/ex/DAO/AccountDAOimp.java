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
				temp.setAccountNumber(rs.getInt(1));
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
			String query = "select * from Accounts where Acc_ID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				acc.setAccountNumber(rs.getInt(1));
				acc.setAccType(rs.getInt(2));
				acc.setBalance(rs.getDouble(3));

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return acc;
	}

	@Override
	public int addAccount(int userID, int accountType) {
		int newAccNumber = (Integer) null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "call new_account (?,?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, userID);
			ps.setInt(2, accountType);

			int rows = ps.executeUpdate();
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					newAccNumber = pk.getInt(1);
				}
				conn.commit();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newAccNumber;

	}

	@Override
	public void removeAccount(int id) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "delete from Accounts where Acc_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateAccountBalance(int id, double newBalance) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "update Accounts set balance = ? where Acc_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, newBalance);
			ps.setInt(2, id);
			ps.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addAccountOwner(int id, int userID) {
		// TODO Auto-generated method stub
		
	}

}
