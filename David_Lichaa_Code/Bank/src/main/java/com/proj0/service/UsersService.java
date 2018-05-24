package com.proj0.service;

import java.util.List;

import com.proj0.dao.UsersDAO;
import com.proj0.pojo.User;

public class UsersService {
	static UsersDAO udao = new UsersDAO();
	
	public List<User> getAll() {
		return udao.getAll();
	}
	
	public boolean insertAccount(String firstName, String lastName, String email, String password) {
		User u = new User(firstName, lastName, email, password);
		return udao.insertAccount(u);
	}
	
	public boolean emailExists(String emailIn) {
		return udao.emailExists(emailIn);
	}
	
	public User getUserByEmail(String email) {
		return udao.getUserByEmail(email);
	}
	
}
