package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.AccountType;
import com.ex.pojos.BankAccount;
import com.ex.util.ConnectionFactory;

public class BankAccountDao implements Dao<BankAccount, Integer>{
	
	//return all bank accounts in the database
	public List<BankAccount> getAll() {
		List<BankAccount> bankAccounts = new ArrayList<BankAccount>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "select * from bank_account";
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				BankAccount temp = new BankAccount();
				temp.setAccount_id(rs.getInt(1));
				temp.setBalance(rs.getDouble(2));
				temp.setBank_type(rs.getInt(3));
				temp.setOwner_id(rs.getInt(4));
				
				bankAccounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankAccounts;
	}
	
	//return the bank account with the given id
	public BankAccount findOne(Integer id) {
		BankAccount temp = new BankAccount();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			//TODO: change this sql statement to match the arg
			String sql = "select * from bank_account where account_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();

			info.next();
			temp.setAccount_id(info.getInt(1));
			temp.setBalance(info.getDouble(2));
			temp.setBank_type(info.getInt(3));
			temp.setOwner_id(info.getInt(4));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	//Insert a new bank account into the database
	public BankAccount save(BankAccount obj) {
		BankAccount bankAccount = obj;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			String query = "insert into bank_account(balance, bank_type, owner_id) VALUES (?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, obj.getBalance());
			ps.setInt(2, obj.getBank_type());
			ps.setInt(3, obj.getOwner_id());

			ps.executeUpdate();
			conn.commit();
			
			query = "select * from Bank_Account where owner_id = ? and bank_type = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, obj.getOwner_id());
			ps.setInt(2, obj.getBank_type());
			ResultSet info = ps.executeQuery();
			info.next();
			bankAccount.setAccount_id(info.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankAccount;
	}
	
	//change the balance of an account
	public BankAccount update(BankAccount obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			conn.setAutoCommit(false);
			
			String query = "update bank_account set balance = ?  where account_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setDouble(1, obj.getBalance());
			ps.setInt(2, obj.getAccount_id() );
			
			
			
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	//checking for unique id
	public boolean isUnique(BankAccount obj) {
		int person_id = obj.getOwner_id();
		int account_type = obj.getBank_type();
		
		boolean exists = true;
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "select * from bank_account where owner_id = ? and bank_type = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, person_id);
			ps.setInt(2, account_type);
			
			ResultSet info = ps.executeQuery();
			
			exists = info.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return exists;
	} 
	
	public AccountType getAccountType(BankAccount obj) {
		AccountType type = new AccountType();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "select * from account_type where typeId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			int typeId = obj.getBank_type();
			ps.setInt(1, typeId);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return type;
		
	}

	public BankAccount getAccount(int ownerid, int accounttype) {
		BankAccount account = new BankAccount();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String query = "select * from bank_account where owner_id = ? and bank_type = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, ownerid);
			ps.setInt(2, accounttype);
			ResultSet info = ps.executeQuery();

			info.next();
			account.setAccount_id(info.getInt(1));
			account.setBalance(info.getDouble(2));
			account.setBank_type(info.getInt(3));
			account.setOwner_id(info.getInt(4));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return account;
	}

}
