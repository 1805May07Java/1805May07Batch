package com.ex.service;

import java.util.Date;
import java.util.List;

import com.ex.dao.ReimbDao;
import com.ex.pojos.Reimbursement;
import com.ex.pojos.User;

public class ReimbursementService {
	static ReimbDao rdao = new ReimbDao();
	
	public List<Reimbursement> getAllReimb()
	{
		return rdao.getAll();
	}
	
	public List<Reimbursement> getReimbursementByUser(User user)
	{
		return rdao.findByUserID(user.getUserID());
	}
	
	public Reimbursement getReimbByID(int id)
	{
		return rdao.findOne(id);	
	}
	
	public Reimbursement addReimbursement(Reimbursement request)
	{
		request.setStatus(0);
		request.setSubmitTime(new Date());
		return rdao.save(request);
	}

	public Reimbursement updateReimbursement(Reimbursement rNew) {
		return rdao.update(rNew);
	}
}
