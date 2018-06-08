package com.Project1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.Project1.dao.UserDao;
import com.Project1.pojos.User;

public class UserServices {

	static UserDao userDao = new UserDao();
	ArrayList<User> allUsers = (ArrayList<User>) getAll();
	
	
	public ArrayList<User> getAll(){
		return userDao.getAll();
	}
	public UserServices() { allUsers = getAll();}
	
	public void update(User u) {
		userDao.update(u);
	}
	
	public User addUser(User u) {
		return userDao.save(u);
	}
	
	public User getById(int id) {
		return userDao.getByID(id);
	}
	
	public User login(String username, String password) {


		Optional<User> user = allUsers.stream().
				filter(u -> u.getUsername().equalsIgnoreCase(username)).findFirst();
		if(user.isPresent()) {
			if(user.get().getPassword().equals(password)) {
				return user.get();
			}
		}
		return null;
	}
}
