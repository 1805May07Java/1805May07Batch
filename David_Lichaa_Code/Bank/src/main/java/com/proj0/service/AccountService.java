package com.proj0.service;

import java.util.ArrayList;
import java.util.List;

import com.proj0.dao.AccountDAO;
import com.proj0.pojo.Account;

public class AccountService {
	static AccountDAO adao = new AccountDAO();
	
	public List<Account> getAll() {
		return adao.getAll();
	}
	
	public Account getByAccountId(int id) {
		return adao.getByAccountId(id);
	}
	
	public boolean insertAccount(int userId, int accountTypeId) {
		Account a = new Account(userId, accountTypeId);
		return adao.insertAccount(a);
	}

	public void withdraw(Account a, int amountToWithdraw) {
		int accountId = a.getAccountId();
		int currBalance = a.getBalance();
		if (amountToWithdraw < 0 || amountToWithdraw > currBalance) { //INVALID WITHDRAW
			System.out.println(amountToWithdraw + " is not a valid amount.");
		} else {
			adao.updateBalance(accountId, currBalance - amountToWithdraw);
			System.out.println("You have successfully withdrawn " + amountToWithdraw + " from your account.");
		}
	}
	
	public void deposit(Account a, int amountToDeposit) {
		int accountId = a.getAccountId();
		int currBalance = a.getBalance();
		if (amountToDeposit < 0) { // INVALID DEPOSIT
			System.out.println(amountToDeposit + " is not a valid amount.");
		} else {
			adao.updateBalance(accountId, currBalance + amountToDeposit);
			System.out.println("You have successfully deposited " + amountToDeposit + " to your account.");
		}
	}
	
	//Returns an ArrayList of accounts owned by this user, or empty list if user has none
	public List<Account> getAccounts(int userId) {
		return adao.getAll(userId);
		
	}
}
