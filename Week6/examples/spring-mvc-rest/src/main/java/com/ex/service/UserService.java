package com.ex.service;

import java.util.List;

import com.ex.beans.User;

public interface UserService {
	
	List<User> getAll();
	User findOne(int id);
	User findByUsername(String username);
	User save(User u);
	
}
