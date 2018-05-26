package com.ex.service;

import java.util.List;

import com.ex.dao.AccountDao;
import com.ex.dao.Dao;
import com.ex.pojos.Account;
import com.ex.pojos.User;

public class AccountService {
	
	static AccountDao accountdao = new AccountDao();
	
	public Account findAccountByID(String id)
	{
		return accountdao.findOne(id);
	}
	
	public Account addAccount(Account account)
	{
		return accountdao.save(account);
	}
	
	public List<Account> getUserAccountList(User user)
	{
		return accountdao.getAll(user);
	}
	
	public Account transferFunds(Account acct, float deltaFund)
	{
		return accountdao.addFunds(acct, deltaFund);
	}
	
	public Account findAccountByNumber(int accountNum)
	{
		return accountdao.findOne(Integer.toString(accountNum));
	}
}
