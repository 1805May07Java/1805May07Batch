package com.major.Daos;

import java.util.ArrayList;

import com.major.pojos.UserRoles;



public interface UserRoleDao 
{
	public UserRoles getType(int id);
	public int getId(String input);
	public ArrayList<UserRoles> getAllRoles();
}
