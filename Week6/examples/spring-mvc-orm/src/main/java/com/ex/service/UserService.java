package com.ex.service;

import java.util.List;

import com.ex.beans.User;

public interface UserService {
	
	List<User> findAll();
	User add(User u);


}
