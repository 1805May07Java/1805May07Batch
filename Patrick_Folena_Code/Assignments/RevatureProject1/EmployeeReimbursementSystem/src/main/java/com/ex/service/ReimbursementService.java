package com.ex.service;

import com.ex.dao.ReimbDao;
import com.ex.pojos.Reimbursement;

public class ReimbursementService {
	static ReimbDao rdao = new ReimbDao();
	
	public Reimbursement findReimbByID(int id)
	{
		return rdao.findOne(id);	
	}
	
	public Reimbursement addReimbursement(Reimbursement request)
	{
		return rdao.save(request);
	}
}
