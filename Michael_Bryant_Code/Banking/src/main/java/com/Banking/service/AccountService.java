package com.Banking.service;

import com.Banking.service.*;
import com.Banking.pojos.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Banking.dao.*;

public class AccountService {
	
	
	static Dao<Account, Integer> accountDao = new AccountDao();
	ArrayList<Account> allAccounts = (ArrayList<Account>) getAllAccounts();
	
	public AccountService() {}
	
	public void update(Account a) {
		accountDao.update(a);
	}

	public List<Account> getAllAccounts(){
		return accountDao.getAll();
	}

	public Account addAccount(Account b){
		return accountDao.save(b);
	}

	public Account getById(int id) {
		return accountDao.findOne(id);
	}

	public Account getByUsername(String user) {
		Account temp= new Account();
		for(Account e: allAccounts) {
			if(e.getUser().equals(user)) {
				temp= e;
				break;
			}
		}
		return temp;
	}
	
	public boolean exists(String username) {
		for(Account a: allAccounts) {
			if(a.getUser().equals(username)) {
				return true;
			}
		}
		
		
		return false;
	}

	public boolean match(String username, String password) {
		for(Account a: allAccounts) {
			if(a.getUser().equals(username) && a.getPass().equals(password)) {

				return true;
			}
		}
		return false;
	}

	
	 
}
