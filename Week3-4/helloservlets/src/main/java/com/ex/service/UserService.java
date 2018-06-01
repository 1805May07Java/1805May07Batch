package com.ex.service;

import java.util.ArrayList;
import java.util.Optional;

import com.ex.pojos.User;

public class UserService {

	static ArrayList<User> users = new ArrayList<User>();
	static int count = 3;
	static {
		users.add(new User(1, "test", "user"));
		users.add(new User(2, "gb", "rev"));
		users.add(new User(3, "more", "thantwothings"));
	}

	
	public ArrayList<User> getAll(){
		return users;
	}
	
	public User getById(int id) {
		Optional<User> user = users.stream().filter(u -> u.getId() == id).findFirst();
		if(user.isPresent()) return user.get();
		else return null;
	}
	// new info = 1, hi, bye // old=1, test, user
	public User updateUser(User newInfo) {
		Optional<User> oldUser = users.stream().filter(u -> u.getId() == newInfo.getId()).findFirst();

		if(oldUser.isPresent()) {
			User user = oldUser.get();
			user.setUsername(newInfo.getUsername());
			user.setPassword(newInfo.getPassword());
			return user;
			
		}
		else return null;
	}

	public boolean isUser(String username) {
		return users.stream().
				filter(u -> u.getUsername().equalsIgnoreCase(username)).count() != 0;
	}

	public User addUser(String username, String password) {
		User temp = new User(++count, username, password);
		users.add(temp);
		return temp;

	}


	public User login(String username, String password) {

		//stream = sequence of elements from a source that supports aggregate ops
		Optional<User> user = users.stream().
				filter(u -> u.getUsername().equalsIgnoreCase(username)).findFirst();
		if(user.isPresent()) {
			if(user.get().getPassword().equals(password)) {
				return user.get();
			}
		}
		return null;
	}





}
