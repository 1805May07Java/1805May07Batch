package com.ex.DAO;

import java.util.ArrayList;

import com.ex.POJO.User;

public interface UserDAO {
	
	public ArrayList<User> getAllStoredUsers();
	public User getById(int id);
	public User addUser(String email, String fName, String lName, String pass);	//TODO sequence makes id num
	public User removeUser(int id);
	
	public void updateUserFirstName(int id, String newFname);
	public void updateUserLastName(int id, String newLname);
	public void updateUserEmail(int id, String newEmail);		//make sure unique
	public void updateUserPassword(int id, String newPass);		//confirm
	
	//public void addAccount(int id, int accountID);  			//TODO not sure how to handle for junction table
}
