package com.bk.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bk.pojos.Access;
import com.bk.pojos.Account;
import com.bk.pojos.User;
import com.bk.util.ConnectionFactory;;

public class DAO implements DataSys {

	
	@Override
	public Access getById(int id) {
		 {
			//getByID	
			 
			//getByID	
			  Access Access = new Access();
				try(Connection conn = ConnectionFactory.getInstance().getConnection()){
					
					String query = "select * from ABS_ACCESS where USR_NAME = ? AND USR_PASSWORD= ?";
					PreparedStatement ps = conn.prepareStatement(query);
					ps.setInt(1, USER);
					ps.setInt(2, PASSWORD);
					ResultSet info = ps.executeQuery();
					
					while(info.next()) {
						Access.setUsername(info.getString(2));
						Access.setPassword(info.getString(3));
						Access.setId(info.getInt(1));
						 
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return Access;
			}
		 
		
	}

	@Override
	public Access getAccessByPass(String usr, String psswrd) {
		 Access Access = new Access();
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				//Retrieve Access Record Item
				String query = "select * from ABS_ACCESS where USR_NAME = ? AND USR_PASSWORD= ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, usr);
				ps.setString(2, psswrd);
				
				ResultSet info = ps.executeQuery();
				while(info.next()) {
				
					Access.setId(info.getInt(ID));
					Access.setUsername(info.getString(USER));
					Access.setPassword(info.getString(PASSWORD));
					;
					 
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return Access;
		}
	public Account getAccountByPass(String usr, String psswrd) {
		 Account Account = new Account();
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				//Retrieve Access Record Item
				String query = "select * from ACCOUNTS where USERID = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, ID);
				ResultSet info = ps.executeQuery();
				while(info.next()) {
				
					Account.setId(info.getInt(ID));
					Account.setUserid(info.getInt(USERID));
					Account.setBalance(info.getDouble(BALANCE));
					Account.setName(info.getString(NAME));
					 
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return Account;
		}
	
 
	public Account getAccountByUsrID(Access usr_access) {
		 Account Account = new Account();
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				//Retrieve Access Record Item
				String query = "select * from ABS_ACCOUNTS where USERID = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, usr_access.getId());
				ResultSet info = ps.executeQuery();
				while(info.next()) {
				
					Account.setId(info.getInt(ID));
					Account.setUserid(info.getInt(USERID));
					Account.setBalance(info.getDouble(BALANCE));
					Account.setName(info.getString(NAME));
					 
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return Account;
		}
	

	public Account newAccount(Access usr_access,double balance,int account_type) {
		 Account Account = new Account();
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				//Insert new Account Information into  Access Record Item
				conn.setAutoCommit(false);
				String query = "INSERT INTO ABS_ACCOUNTS (USERID, NAME, BALANCE,TYPEID) VALUES (?, ?, ?,?)";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, usr_access.getId());
				ps.setString(2, "ACC1");
				ps.setDouble(3, balance);
				ps.setInt(4, account_type);
				int info = ps.executeUpdate();
				if (info > 0 ) {
					Account.setId(getNewAccountId());
				}
				conn.commit();
				

				
			} 
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			return Account;
		}

	public int getNewAccountId() throws SQLException {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			//Insert new Account Information into  Access Record Item
			String query = "select abs_accounts.id from abs_accounts";
			Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet r = s.executeQuery(query);
			r.last();
			return r.getInt(1);
		    	 
		       
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		
		  return -1;
		// TODO Auto-generated method stub
		
	}
	public Account getAllAccByAccID(int accId) {
		 Account Account = new Account();
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				//Retrieve Access Record Item
				String query = "select ID,USERID, NAME, BALANCE from ABS_ACCOUNTS where ID = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, accId);
				ResultSet info = ps.executeQuery();
				while(info.next()) { 
				
				Account.setId(info.getInt(ID));
				Account.setUserid(info.getInt(USERID));
				Account.setName(info.getString(NAME));
				Account.setBalance(info.getDouble(BALANCE));
				
				
				}
					 
				return Account;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		
		
		return null;
		// TODO Auto-generated method stub
		
	}
	public Account getAccByAccID(int accId) {
		 Account Account = new Account();
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				//Retrieve Access Record Item
				String query = "select ID from ABS_ACCOUNTS where ID = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, accId);
				ResultSet info = ps.executeQuery();
				while(info.next()) { 
				
				Account.setId(info.getInt(ID));
				}
					 
				return Account;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		
		
		return null;
		// TODO Auto-generated method stub
		
	}

	public int newCust(boolean status, int Accid, int userid,String email) {
		// TODO Auto-generated method stub
		if(status) {
		       User Customer = new User();
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				//Insert new Account Information into  Access Record Item
				conn.setAutoCommit(false);
				String query = "INSERT INTO ABS_USERS (USERID, EMAIL, ACCID) VALUES (?, ?, ?)";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1,userid);
				ps.setString(2, email); //Check for Uniquenesss and valid email
				ps.setInt(3, Accid);
				int info = ps.executeUpdate();
				conn.commit();
				
                return info;
				
			} 
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			return -1;
		}
		return -1;
	}

	public User getCustByAccId(int id) {
		 User Customer = new User();
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				//Retrieve Access Record Item
				String query = "select ACCID from ABS_USERS where ACCID = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, id);
				ResultSet info = ps.executeQuery();
				while(info.next()) { 
					Customer.setAccId(info.getInt(1));
				}
					 
				return Customer;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		
		
		return null;
		
	}

	public int saveAccount(Account account) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			//Insert new Account Information into  Access Record Item
			conn.setAutoCommit(false);
			String query = "UPDATE ABS_ACCOUNTS SET USERID=?, NAME=?, BALANCE= ? WHERE ID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, account.getUserid());
			ps.setString(2, account.getName());
			ps.setDouble(3, account.getBalance());
			ps.setInt(4, account.getId());
			int info = ps.executeUpdate();
		   
			conn.commit();
			return info;

			
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	

 

 
	 
	//public ArrayList<Account> getAll();
//	public Account getById(int id);
//	public Account addAccount(String name);
//	public Account updateAccount(int id, String name);
//	public Account createAccount(int id, String name);
	 

	}
