package com.major.util;

import java.util.ArrayList;

import com.major.Daos.ReimbStatusDaoImpl;
import com.major.Daos.ReimbTypeDaoImpl;
import com.major.Daos.UserRoleDaoImpl;
import com.major.pojos.ReimbStatus;
import com.major.pojos.ReimbType;
import com.major.pojos.UserRoles;

public class LookupService 
{
	static ReimbStatusDaoImpl StatusDAO = new ReimbStatusDaoImpl();
	static ReimbTypeDaoImpl TypeDAO = new ReimbTypeDaoImpl();
	static UserRoleDaoImpl RoleDAO = new UserRoleDaoImpl();
	
	//Status Methods
	public ReimbStatus getStatus(int id) 
	{
		return StatusDAO.getStatus(id);
	}
	
	public int getStatusId(String input) 
	{
		return StatusDAO.getId(input);
	}
	
	public ArrayList<ReimbStatus> getAllStatuses()
	{
		return StatusDAO.getAllStatuses();
	}
	//End Status Methods
	
	
	//Type Methods
	public ReimbType getType(int id) 
	{
		return TypeDAO.getType(id);
	}
	
	public int getTypeId(String input) 
	{
		return TypeDAO.getId(input);
	}
	
	public ArrayList<ReimbType> getAllTypes()
	{
		return TypeDAO.getAllTypes();
	}
	//End Type Methods
	
	
	//Role Methods
	public UserRoles getRole(int id) 
	{
		return RoleDAO.getType(id);
	}
	
	public int getRoleId(String input) 
	{
		return RoleDAO.getId(input);
	}
	
	public ArrayList<UserRoles> getAllRoles()
	{
		return RoleDAO.getAllRoles();
	}
}
