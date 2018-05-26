package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Account;
import com.ex.pojos.AccountType;
import com.ex.pojos.User;
import com.ex.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class AccountDao implements Dao<Account, String>{

	public List<Account> getAll() {
		List<Account> accts = new ArrayList<Account>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from accounttype";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) { //Author: author_id, firstname, lastname, bio 
				Account temp = new Account();
				temp.setID(rs.getInt(1));
				temp.setAccountType(rs.getInt(2));
				
				temp.setJoint(rs.getString(3).equals("1"));
				temp.setJointPassword(rs.getString(4));
				temp.setAccountNumber(rs.getString(5));
				temp.setAccountAmount(rs.getFloat(6));
				temp.setNickname(rs.getString(7));
				accts.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accts;
	}
	
	public List<Account> getAll(User user) 
	{
		List<Account> accts = new ArrayList<Account>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM ACCOUNTLIST "
					+ "INNER JOIN USERACCOUNTLINK "
					+ "ON ACCOUNTLIST.ACCOUNTID=USERACCOUNTLINK.ACCOUNTID "
					+ "WHERE USERACCOUNTLINK.userid = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, user.getID());
			
			ResultSet rs = ps.executeQuery();

			while(rs.next()) { //Author: author_id, firstname, lastname, bio 
				Account temp = new Account();
				temp.setID(rs.getInt(1));
				temp.setAccountType(rs.getInt(2));
				
				temp.setJoint(rs.getString(3).equals("1"));
				temp.setJointPassword(rs.getString(4));
				temp.setAccountNumber(rs.getString(5));
				temp.setAccountAmount(rs.getFloat(6));
				temp.setNickname(rs.getString(7));
				accts.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accts;
	}

	public Account findOne(String accountNum) {
		Account acct = new Account();
		int accountNumber = -1;
		accountNumber = Integer.parseInt(accountNum);
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT * FROM ACCOUNTLIST WHERE accountNumber = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, accountNumber);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				acct.setID(rs.getInt(1));
				acct.setAccountType(rs.getInt(2));
				acct.setJoint(rs.getString(3).equals("1"));
				acct.setJointPassword(rs.getString(4));
				acct.setAccountNumber(rs.getString(5));
				acct.setAccountAmount(rs.getFloat(6));
				acct.setNickname(rs.getString(7));
			}
			else return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acct;
	}

	public Account save(Account obj) {
		Account acct = new Account();
		acct.copy(obj);
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO accountlist(accounttypeid, isjoint, jointpassword, accountbalance, nickname)"
					+ "values(?,?,?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "accountid";
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setInt(1, obj.getAccountType());
			
			String hold = obj.isJoint() ? String.valueOf('1'):String.valueOf('0');
			ps.setString(2, hold);
			
			ps.setString(3, obj.getJointPassword());
			ps.setFloat(4, (float) obj.getAccountAmount());
			ps.setString(5, obj.getNickname());
			
			//ps.setString(5, generateAccountNumber)
			//This would be here for the generation, subsequent checking, and creation
			//of individual account numbers as dictated by the bank.
			//In this case, we're simply using a trigger for ease inside the DB itself
			//WHICH can easily be removed and replaced with this method here.
			//Just haven't figured the algorithm for account number generation out yet
			//(Gets trickier when there is a large set of accounts to go through)
			//Default null values until then...
			
			int rows = ps.executeUpdate();
			
			if(rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					acct.setID(pk.getInt(1));
				}
				
				conn.commit();
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		};	
		return acct;
	}

	public Account update(Account obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isUnique(Account obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public Account addFunds(Account account, float deltaFund) 
	{
		Account acct = new Account();
		acct.copy(account);
		acct.setAccountAmount(account.getAccountAmount() + deltaFund);
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			
			CallableStatement cs = conn.prepareCall("{call move_funds(?,?)}");
			cs.setInt(1, account.getID());
			cs.setFloat(2, deltaFund);
			
			cs.execute();
			conn.commit();
		}  catch (SQLException e) {
			e.printStackTrace();
		};	
		
		return acct;
	}

}