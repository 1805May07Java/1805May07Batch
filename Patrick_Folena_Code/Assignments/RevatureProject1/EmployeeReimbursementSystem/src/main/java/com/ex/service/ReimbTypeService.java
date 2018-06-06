package com.ex.service;

import java.util.ArrayList;
import java.util.List;

import com.ex.dao.ReimbTypeDao;
import com.ex.pojos.ReimbType;

public class ReimbTypeService {
	static ReimbTypeDao typedao = new ReimbTypeDao();
	
	public String getTypeByID(int id)
	{
		System.out.println("FIND ONE : " + typedao.findOne(id).getID());
		return typedao.findOne(id).getType();
	}
	
	public List<String> getAllTypes()
	{
		List<String> listString = new ArrayList<String>();
		List<ReimbType> list = typedao.getAll();
		for(int i = 0; i < list.size(); i++)
		{
			listString.add(list.get(i).getType());
		}
		return listString;
	}
}
