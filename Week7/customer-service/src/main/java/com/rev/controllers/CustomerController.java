package com.rev.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rev.entities.Customer;
import com.rev.intercomm.AccountClient;

@RestController
public class CustomerController {
	
	@Autowired
	private AccountClient ac;
	
	private List<Customer> customers = new ArrayList<>();
	
	public CustomerController() {
		customers.add(new Customer(1, "test", null));
		customers.add(new Customer(2, "gen", null));
	}
	
	@GetMapping("{id}")
	public Customer findById(@PathVariable int id) {
		//find the customer in our customers list (turned to a stream) of which the id is the same as the param
		Customer customer = customers.parallelStream().filter(cust -> cust.getId() == id).findFirst().get();
		//send HTTP request from java -- can use REST Template, but we will use FEIGN CLIENT
		customer.setAccounts(ac.findByCustomerId(id));
		return customer;
	}
	

}
