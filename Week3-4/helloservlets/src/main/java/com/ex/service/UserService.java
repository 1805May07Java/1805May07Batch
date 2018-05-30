package com.ex.service;

import java.util.ArrayList;
import java.util.Optional;

import com.ex.pojos.User;

public class UserService {

	static ArrayList<User> users = new ArrayList<User>();
	static int count = 2;
	static {
		users.add(new User(1, "test", "user"));
		users.add(new User(2, "gb", "rev"));
	}

	public ArrayList<User> getAll(){
		return users;
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
