package com.rev.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rev.entities.Account;

@RestController
public class AccountController {

	private List<Account> accounts = new ArrayList<Account>();
	public AccountController() {
		accounts.add(new Account(1, 1, 17.38));
		accounts.add(new Account(2, 2, 100000000.00));
		accounts.add(new Account(3, 3, 7000));
		accounts.add(new Account(4, 15, 600));
	}


	@GetMapping
	public List<Account> getAll() {
		return accounts;
	}

	@GetMapping("/{id}")
	public Account findById(@PathVariable int id) {
		return accounts.parallelStream().filter(account -> account.getId()==id).findFirst().get();
	}
	
	@GetMapping("/customer/{id}")
	public List<Account> findByCustomer(@PathVariable int id){
		return accounts.parallelStream().filter(account -> account.getCustomerId() == id).collect(Collectors.toList());
	}



}
