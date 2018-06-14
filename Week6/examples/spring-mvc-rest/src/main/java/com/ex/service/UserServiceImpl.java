package com.ex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ex.beans.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	static ArrayList<User> users = new ArrayList<User>();
	static int count = 4;
	static {
		users.add(new User(1, "username", "password", "firstname", "lastname"));
		users.add(new User(2, "genesis", "bonds", "gb", "123"));
		users.add(new User(3, "mylastname", "hasnothingtodo", "withJamesBond", "orbarrybonds"));
	}

	public List<User> getAll() {
		return users;
	}

	public User findOne(int id) {
		return new User();
	}

	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public User save(User u) {
		u.setId(count++);
		users.add(u);
		return u;
	}

}
