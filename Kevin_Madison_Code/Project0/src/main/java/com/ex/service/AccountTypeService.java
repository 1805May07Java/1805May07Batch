package com.ex.service;

import java.util.List;

import com.ex.dao.AccountTypeDao;
import com.ex.dao.Dao;
import com.ex.pojos.AccountType;

public class AccountTypeService {
	static Dao<AccountType, Integer> accountTypeDao = new AccountTypeDao();
	
	public List<AccountType> getAll(){
		return accountTypeDao.getAll();
	}
}
