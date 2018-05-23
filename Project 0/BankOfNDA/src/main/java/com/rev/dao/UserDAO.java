package com.rev.dao;

import java.util.ArrayList;
import com.rev.pojos.User;

public interface UserDAO {
	public ArrayList<User> getAllUsers();
	public void addUser(User u);
	public Boolean findUser(String username);
	public User getUser(String userName);
}
