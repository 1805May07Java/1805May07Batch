package com.proj0.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proj0.pojo.Account;
import com.proj0.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class AccountDAO {
/* returns all bank accounts found in the table Account */
	public List<Account> getAll() {
		List<Account>accounts = new ArrayList<Account>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from account";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				Account a = new Account();
				a.setAccountId(rs.getInt(1));
				a.setUserId(rs.getInt(2));
				a.setAccountTypeId(rs.getInt(3));
				a.setBalance(rs.getInt(4));
				accounts.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	/* Returns an ArrayList of all accounts owned by the user with user_id userId */
	public List<Account> getAll(int userId) {
		ArrayList<Account> accounts = new ArrayList<Account>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from account where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Account a = new Account();
				a.setAccountId(rs.getInt(1));
				a.setUserId(rs.getInt(2));
				a.setAccountTypeId(rs.getInt(3));
				a.setBalance(rs.getInt(4));
				accounts.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	/* Given an account_id, return the Account object associated with said id */
	public Account getByAccountId(int id) {
		Account a = new Account();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from account where account_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			a.setAccountId(rs.getInt(1));
			a.setUserId(rs.getInt(2));
			a.setAccountTypeId(rs.getInt(3));
			a.setBalance(rs.getInt(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	/* Inserts account into database */
	public boolean insertAccount(Account in) {
		boolean ret = false;
		Account a = new Account();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO account (User_id, Account_type_id, Balance) VALUES (?, ?, ?)";
			String[] keys = new String[1];
			keys[0] = "account_id";
			PreparedStatement ps = conn.prepareStatement(sql, keys);

			ps.setInt(1, in.getUserId());
			ps.setInt(2, in.getAccountTypeId());
			ps.setInt(3, in.getBalance());
			
			int rows = ps.executeUpdate();
			if (rows != 0) {
				ResultSet rs = ps.getGeneratedKeys();
				while (rs.next()) {
					a.setAccountId(rs.getInt(1));
				}
			}
			conn.commit();
			ret = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	/* directly update the account with account_id to have a new balance of newBalance */
	public boolean updateBalance(int accountId, int newBalance) {
		boolean ret = false;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
//			conn.setAutoCommit(false);
			String sql = "{call update_account_balance (?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, accountId);
			cs.setInt(2, newBalance);
			cs.execute();
//			conn.commit();
			ret = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
}