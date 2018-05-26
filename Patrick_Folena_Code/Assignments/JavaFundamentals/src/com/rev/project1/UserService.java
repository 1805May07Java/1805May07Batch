package com.rev.project1;

import java.util.ArrayList;

public class UserService {
	static ArrayList<User> users;
	static {
		users = new ArrayList<User>();
	}
	
	User addNewUser(String userName, String passWord, String firstName, String lastName, String email, double cashAmount)
	{	
		User n = new User(userName, passWord, firstName, lastName, email, cashAmount);
		IODAO dao = new IODAO();
		dao.addUser(n);
		return n;
	}
	
	void changeUser(String oldUser, String newUser)
	{
		IODAO dao = new IODAO();
		dao.changeUser(oldUser, newUser);
	}
	
	ArrayList<User> getAllUsers(){
		//until we deal w DAO, all we do here is return our static arraylist
		IODAO dao = new IODAO();
		return dao.readUsers();
	}
	
	public boolean exists (String username) 
	{
		ArrayList<User> users = getAllUsers();
		return users.stream().anyMatch(name->name.getUserName().equalsIgnoreCase(username));
	}
	
	public User getByUsername(String username) {
        return getAllUsers().stream().
                filter(s -> s.getUserName().equalsIgnoreCase(username)).
                    findFirst().get();
    }
}
