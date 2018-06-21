package com.ex.service;

import java.util.List;

import com.ex.entities.Account;


public interface AccountService {

	List<Account> findAll();
	Account findById(int id);
	List<Account> findByCustomer(int id);
	Account add(Account acc);
}
