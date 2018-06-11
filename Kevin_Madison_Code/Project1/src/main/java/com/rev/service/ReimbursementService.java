package com.rev.service;

import java.util.List;

import com.rev.dao.ReimbursementDao;
import com.rev.pojo.Reimbursement;

public class ReimbursementService {
	static ReimbursementDao reimbDao = new ReimbursementDao();

	public List<Reimbursement> getAll() {
		return reimbDao.getAll();
	}
	
	public List<Reimbursement> getAllReimbById(int id){
		return reimbDao.getAllById(id);
	}
	
	public Reimbursement getById(int id) {
		return reimbDao.getById(id);
	}
	
	public void addReimbursement(int amount, int type, String description, int userId) {
		Reimbursement obj = new Reimbursement();
		obj.setAmount(amount);
		obj.setTypeId(type);
		obj.setDescription(description);
		obj.setAuthor(userId);
		reimbDao.save(obj);
	}
	
	public Reimbursement resolveReimbursement(int id, int resolverId, int status) {
		return reimbDao.resolveReimbursement(id, resolverId, status);
	}
}
