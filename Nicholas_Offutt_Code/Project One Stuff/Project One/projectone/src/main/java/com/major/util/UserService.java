package com.major.util;

import java.util.ArrayList;

import com.major.Daos.UserDaoImpl;
import com.major.pojos.ErsUser;

public class UserService 
{
	
	static UserDaoImpl UseDAO = new UserDaoImpl();
	
	public boolean validate(String userName, String password) 
	{
		
		ErsUser temp = UseDAO.getByName(userName);
		
		if(temp.getPassword().equals(password)) 
		{
			return true;
		}
		return false;
	}
	
	public ErsUser getUserByName(String userName) 
	{
		return UseDAO.getByName(userName);
	}
	
	public ErsUser getById(int id) 
	{
		return UseDAO.getById(id);
	}
	
	public ErsUser update(ErsUser entry) 
	{
		return UseDAO.updateUser(entry);
	}
	
	public ErsUser create(ErsUser entry) 
	{
		return UseDAO.createUser(entry);
	}
	
	public ArrayList<ErsUser> getAll()
	{
		return UseDAO.getAllUsers();
	}
	
	public boolean available(String userName, String email) 
	{
		return UseDAO.isFree(userName, email);
	}
}
