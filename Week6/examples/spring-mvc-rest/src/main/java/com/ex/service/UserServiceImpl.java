package com.ex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		Optional<User> test = users.stream().filter( u -> u.getId() == id).findFirst();
		if(test.isPresent()) return test.get();
		return null;
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

	@Override
	public User update(User u) {
		User oldUser = findOne(u.getId());
		if(oldUser == null) {
			return null;
		} else {
			oldUser = u;
		}
		return u;
	}

	@Override
	public void delete(User u) {
		// TODO Auto-generated method stub
		
	}

}
