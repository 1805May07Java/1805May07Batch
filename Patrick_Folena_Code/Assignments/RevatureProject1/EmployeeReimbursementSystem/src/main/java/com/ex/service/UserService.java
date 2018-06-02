package com.ex.service;

import java.util.ArrayList;
import java.util.List;

import com.ex.dao.UserDao;
import com.ex.pojos.User;

public class UserService {
	
	static UserDao userdao = new UserDao();
	
	public User findUserByID(int id)
	{
		return userdao.findOne(id);
	}
	
	public User findUserByName(String name)
	{
		return userdao.findOneByName(name);
	}
	
	public List<User> getAllUsers()
	{
		return userdao.getAll();
	}
	
	public User addUser(User user)
	{
		return userdao.save(user);
	}
	
	public User logIn(String username, String password)
	{
		User test = findUserByName(username.toUpperCase());
		if(test != null && test.getPassword().equals(password))
		{
			System.out.println("SUCCESSFUL RETRIEVAL! LOGIN IMMINENT!");
			return test;
		}
		return null;
	}
}