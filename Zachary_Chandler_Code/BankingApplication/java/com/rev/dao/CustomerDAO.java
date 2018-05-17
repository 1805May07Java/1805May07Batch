package com.rev.dao;

import com.rev.pojo.Customer;

public interface CustomerDAO {

	boolean exists(String email);

	Customer create(String email, String password, String firstName, String lastName);

	Customer get(String email);

	Customer get(long customerID);

}