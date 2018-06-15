package com.ex.dao;

import java.util.List;

import com.ex.beans.User;

public interface UserDao {

	User add(User u);
	List<User> getAll();
	User findOne(int id);
	User findByUsername(String username);
}
