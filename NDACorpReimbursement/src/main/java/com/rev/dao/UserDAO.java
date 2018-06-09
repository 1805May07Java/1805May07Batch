package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojos.User;

public interface UserDAO {
	public ArrayList<User> getAllUsers();
	public User addUser(User u);
	public User getUser(String userName);
	public User getUser(int userId);
	public boolean updateUser(User u);
	public String getRole(int userId);
}
