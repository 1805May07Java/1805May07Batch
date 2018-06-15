package com.ex.service;

import java.util.List;

import com.ex.model.User;

public interface UserService {
	
	User addUser(User u);
	List<User> getAll();
	User findByUsername(String username);

}
