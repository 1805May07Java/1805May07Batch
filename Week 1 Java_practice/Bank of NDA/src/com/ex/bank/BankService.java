package com.ex.bank;

import java.util.ArrayList;

public class BankService {
	
	private static ioDAO dao = new ioDAO();
	
	//get all users
	ArrayList<User> getAllUsers(){
		return dao.getAllUsers();
	}
	
	//check to see if userName is in database
	boolean exists(String userName) {
		ArrayList<User> users = getAllUsers();
		return users.stream().anyMatch(s -> s.getUserName().equalsIgnoreCase(userName));
	}
	
	//get a user by the name
	User getByUserName(String userName) {
		return getAllUsers().stream().filter(s -> s.getUserName().
				equalsIgnoreCase(userName)).findFirst().get();
	}
	
	//add a new user
	void addUser(String fName, String lName, String uName, String pass) {
		User u = new User(fName, lName, uName, pass, 0);
		dao.addUser(u);
	}
	
	//update a user
	void updateUser(User u) {
		ArrayList<User> users = getAllUsers();
		for(int i = 0; i < users.size();i++) {
			if(users.get(i).getUserName().equals(u.getUserName())){
				users.set(i, u);
			}
		}
		dao.addAllUsers(users);
	}
}
