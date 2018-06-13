package com.ex.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ex.beans.User;

@Component
public class ServiceImpl implements LoginService{
	
	static ArrayList<User> users = new ArrayList<User>();
	
	static {
		users.add(new User("Genesis", "123", "N/A"));
		users.add(new User("test", "user", "black"));
		users.add(new User("another person", "password", "yellow"));
	}
	
	public User login(String username, String password) {

		//stream = sequence of elements from a source that supports aggregate ops
		Optional<User> user = users.stream().
				filter(u -> u.getName().equalsIgnoreCase(username)).findFirst();
		if(user.isPresent()) {
			if(user.get().getPass().equals(password)) {
				return user.get();
			}
		}
		return null;
	}

}
