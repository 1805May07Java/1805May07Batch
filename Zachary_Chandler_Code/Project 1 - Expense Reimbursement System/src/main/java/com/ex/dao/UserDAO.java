package com.ex.dao;

import com.ex.pojo.User;

public interface UserDAO {

	User login(String username, String password);
	User get(String username);
	User get(long userID);
}
