package com.ex.dao;
import java.util.List;
import com.ex.pojos.User;

public interface UserDao {

	public User logIn(String username, String password);
	public boolean insertUser(User usr);
	public User getUser(String username);
	public boolean updateUser(User usr);
	public List<User> getAllUsers();
	
}

