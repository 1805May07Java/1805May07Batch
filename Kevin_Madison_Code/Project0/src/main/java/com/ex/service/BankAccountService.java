package com.ex.service;

import java.util.List;

import com.ex.dao.BankAccountDao;
import com.ex.dao.Dao;
import com.ex.pojos.BankAccount;


public class BankAccountService {
	static BankAccountDao accounts = new BankAccountDao();
	
	public List<BankAccount> getAll(){
		return accounts.getAll();
	}
	
	public BankAccount add(BankAccount obj) {
		return accounts.save(obj);
	}
	
	public BankAccount getAccount(int ownerid, int accounttype) {
		return accounts.getAccount(ownerid, accounttype);
	}
	
	public boolean exists(BankAccount obj) {
		return accounts.isUnique(obj);
	}
	
	public BankAccount update(BankAccount obj) {
		return accounts.update(obj);
	}
}
