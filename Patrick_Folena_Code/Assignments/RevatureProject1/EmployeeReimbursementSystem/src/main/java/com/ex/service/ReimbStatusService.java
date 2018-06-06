package com.ex.service;

import java.util.ArrayList;
import java.util.List;

import com.ex.dao.ReimbStatusDao;
import com.ex.pojos.ReimbStatus;
import com.ex.pojos.ReimbType;

public class ReimbStatusService {
	static ReimbStatusDao statusdao = new ReimbStatusDao();
	
	public String getStatusByID(int id)
	{
		return statusdao.findOne(id).getStatus();
	}

	public List<String> getAllStatus() {
		List<String> listString = new ArrayList<String>();
		List<ReimbStatus> list = statusdao.getAll();
		for(int i = 0; i < list.size(); i++)
		{
			listString.add(list.get(i).getStatus());
		}
		return listString;
	}
}
