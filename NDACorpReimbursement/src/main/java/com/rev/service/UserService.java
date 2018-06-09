package com.rev.service;

import java.util.Optional;

import com.rev.dao.UserDAO;
import com.rev.dao.UserDAOImpl;
import com.rev.pojos.User;

public class UserService {

	public User login(String userName, String password) {
		UserDAO dao = new UserDAOImpl();
		User u = dao.getUser(userName);
		
		if (u != null) {
			if (u.getPassword().equals(password)) {
				return u;
			}
			else {
				System.out.println("wrong");
				u = null;
				return u;
			}
		}
		
		return null;
		
	}

	public User signUp(User u) {
		UserDAO dao = new UserDAOImpl();
		User t = dao.addUser(u);
		
		if(t != null) {
			return t;
		}
		return t;
	}

	public boolean update(User u) {
		UserDAO dao = new UserDAOImpl();
		boolean t = dao.updateUser(u);
		return t;
	}

}
