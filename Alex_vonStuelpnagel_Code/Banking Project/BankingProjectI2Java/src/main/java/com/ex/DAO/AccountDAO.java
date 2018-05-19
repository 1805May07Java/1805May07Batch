package com.ex.DAO;

import java.util.ArrayList;

import com.ex.POJO.Account;

public interface AccountDAO {
	
	public ArrayList<Account> getAllStoredAccounts();
	public Account getById(int id);
	public Account addAccount(int accountType);						//sequence makes id num
	public void removeAccount(int id);	
	
	public void updateAccountBalance(int id, int newBalance);
	
	public void addAccountOwner(int id, int userID);				//make sure not already on account

}