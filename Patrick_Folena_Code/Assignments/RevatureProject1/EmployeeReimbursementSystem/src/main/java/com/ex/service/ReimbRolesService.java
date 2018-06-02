package com.ex.service;

import com.ex.dao.ReimbRolesDao;

public class ReimbRolesService {
	
	static ReimbRolesDao rolesdao = new ReimbRolesDao();
	
	public String getRoleByID(int id)
	{
		return rolesdao.findOne(id).getRole();
	}
}
