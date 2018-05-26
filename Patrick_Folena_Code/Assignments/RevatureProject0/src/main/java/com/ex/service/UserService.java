package com.ex.service;

import com.ex.dao.UserDao;
import com.ex.dao.Dao;
import com.ex.dao.UserAccountDao;
import com.ex.pojos.Account;
import com.ex.pojos.User;
import com.ex.pojos.UserAccount;

public class UserService {
	static Dao<User, String> userdao = new UserDao();
	static Dao<UserAccount, Integer> uadao = new UserAccountDao();
	
	public User findUserByName(String name)
	{
		return userdao.findOne(name);
	}
	
	public User addUser(User user)
	{
		return userdao.save(user);
	}
	
	public User updateUser(User user)
	{
		return userdao.update(user);
	}
	
	public UserAccount addUserAccount(User user, Account acct)
	{
		return uadao.save(new UserAccount(user, acct));
	}
}
