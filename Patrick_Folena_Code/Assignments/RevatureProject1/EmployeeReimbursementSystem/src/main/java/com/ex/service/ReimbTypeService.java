package com.ex.service;

import com.ex.dao.ReimbTypeDao;

public class ReimbTypeService {
	static ReimbTypeDao typedao = new ReimbTypeDao();
	
	public String getTypeByID(int id)
	{
		return typedao.findOne(id).getType();
	}
}
