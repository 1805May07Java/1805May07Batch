package com.ex.DAO;

import java.util.ArrayList;

import com.ex.POJO.Account;

public interface AccountDAO {
	
	public ArrayList<Account> getAllStoredAccounts();
	public Account getById(int id);
	public void addAccount(int userID, int accountType);						
	public void removeAccount(int id);
	
	public boolean checkAccID(int ID);
	
	public void updateAccountBalance(int id, double newBalance);
	
	public boolean addAccountOwner(int accID, int userID);
	public void removeAccountOwner(int accID, int userID);

}