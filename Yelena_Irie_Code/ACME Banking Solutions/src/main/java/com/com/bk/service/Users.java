package com.bk.service;

import com.bk.pojos.Access;
import com.bk.pojos.User;

public class Users extends Accounts{

	public Users(Access usr_access) {
		super(usr_access);
		// TODO Auto-generated constructor stub
	}
    public User createUser(User user) {
    	
    	return user;
    }
}
