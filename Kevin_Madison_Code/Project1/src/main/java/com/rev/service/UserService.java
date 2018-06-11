package com.rev.service;

import java.util.List;

import com.rev.dao.UserDao;
import com.rev.pojo.User;

public class UserService {
static UserDao userdao = new UserDao();
	
	public void add(User a) {
		userdao.save(a);
	}
	
	public List<User> getAll(){
		return userdao.getAll();
	}

	public User getById(int id) {
		return userdao.findOne(id);
	}

	public User login(String username, String password) {
		
		if(username.equals("") || password.equals("")) return null;
		if(userdao.login(username, password)) {
			System.out.println("In user service login method.");
			return userdao.getUserByName(username);
		}else {
			return null;
		}
	}

	public User updateUser(User u) {
		return userdao.update(u);
	}

	public User addUser(String username, String password, String fn, String ln, String email, int userRole) {
		// TODO Auto-generated method stub
		User temp = new User();
		temp.setUsername(username);
		temp.setPassword(password);
		temp.setFirstname(fn);
		temp.setLastname(ln);
		temp.setEmail(email);
		temp.setUserRoleId(userRole);
		return userdao.save(temp);
	}
}
