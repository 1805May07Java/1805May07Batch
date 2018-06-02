package com.ex.service;

import com.ex.dao.ReimbStatusDao;

public class ReimbStatusService {
	static ReimbStatusDao statusdao = new ReimbStatusDao();
	
	public String getStatusByID(int id)
	{
		return statusdao.findOne(id).getStatus();
	}
}
