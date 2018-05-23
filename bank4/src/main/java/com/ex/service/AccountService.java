package com.ex.service;

import java.util.UUID;

import com.ex.dao.AccountDAO;
import com.ex.pojo.Account;

public class AccountService {

	static AccountDAO dao = new AccountDAO();
	
	public static void makeNewAccount(UUID accountid,String accounttype) {
		Account account = new Account(accountid,accounttype, 0.0);
		
		dao.save(account);
		
	}
	
	public static double getBalance(UUID accountid) {
		return dao.getBalance(accountid);
	}
	
	public static void deposit(UUID accountid, double amount) {
		dao.deposit(accountid, amount);
	}
}
