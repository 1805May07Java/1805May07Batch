package com.ex.DAO;

import java.util.ArrayList;

import com.ex.POJO.Account;
import com.ex.POJO.User;

public interface UserDAO {
	
	public ArrayList<User> getAllStoredUsers();
	public User getById(int id);
	public User getByEmail(String email);
	public User addUser(String email, String fName, String lName, String pass);	//TODO sequence makes id num
	public void removeUser(int id);
	public void makeAdmin(int id);
	
	public boolean checkUserEmail(String email);
	public boolean checkUserID(int id);
	public boolean checkIsAdmin(int id);
	public boolean checkUserPassword(int id, String pass);
	
	public void updateUserFirstName(int id, String newFname);
	public void updateUserLastName(int id, String newLname);
	public void updateUserEmail(int id, String newEmail);		//make sure unique
	public void updateUserPassword(int id, String newPass);		//confirm
	
	public ArrayList<Account> getUserAccounts(int id);
	public ArrayList<Integer> getUserAccountNumbers(int id); 
}
