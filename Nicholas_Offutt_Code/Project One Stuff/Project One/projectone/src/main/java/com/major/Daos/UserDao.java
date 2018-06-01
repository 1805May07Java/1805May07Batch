package com.major.Daos;

import java.util.ArrayList;

import com.major.pojos.ErsUser;

public interface UserDao 
{
	public ErsUser getById(int id);
	public ArrayList<ErsUser> getAllUsers();
	public boolean isFree(String userName, String password);
	public ErsUser createUser(ErsUser obj);
	public ErsUser updateUser(ErsUser obj);
}
