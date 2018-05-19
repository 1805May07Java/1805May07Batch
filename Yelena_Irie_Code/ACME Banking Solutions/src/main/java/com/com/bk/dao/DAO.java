package com.bk.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bk.pojos.Access;
import com.bk.pojos.Account;
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
				
					Account.setID(info.getInt(ID));
					Account.setUsrId(info.getString(USERID));
					Account.setBalance(info.getString(BALANCE));
					Account.setName(info.getString(NAME));
					 
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return Account;
		}
	
 
	public Account getAccountByInt(Access usr_access) {
		 Account Account = new Account();
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				//Retrieve Access Record Item
				String query = "select * from ACCOUNTS where USERID = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, usr_access.getId());
				ResultSet info = ps.executeQuery();
				while(info.next()) {
				
					Account.setID(info.getInt(ID));
					Account.setUsrId(info.getString(USERID));
					Account.setBalance(info.getString(BALANCE));
					Account.setName(info.getString(NAME));
					 
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return Account;
		}
	

 
 

 
	 
	//public ArrayList<Account> getAll();
//	public Account getById(int id);
//	public Account addAccount(String name);
//	public Account updateAccount(int id, String name);
//	public Account createAccount(int id, String name);
	 

	}
