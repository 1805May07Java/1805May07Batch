package com.ex.services;

import java.util.List;

import com.ex.models.User;

public interface UserService {
	
	List<User> getAll();
	User add(User u);
	User findById(int id);
	User findByUsername(String username);
	User update(User u);
	

	
}
