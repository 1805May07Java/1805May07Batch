package com.major.util;

import java.util.ArrayList;

import com.major.Daos.ReimbDaoImpl;
import com.major.pojos.ErsUser;
import com.major.pojos.Reimbursement;

public class ReimbursementService 
{
	static ReimbDaoImpl ReimbDAO =new ReimbDaoImpl();
	
	public Reimbursement getById(int id) 
	{
		return ReimbDAO.getById(id);
	}
	
	public ArrayList<Reimbursement> getByAuthor(ErsUser requester)
	{
		return ReimbDAO.getByAuthor(requester);
	}
	
	public ArrayList<Reimbursement> getByResolver(ErsUser resolver)
	{
		return ReimbDAO.getByAuthor(resolver);
	}
	
	public Reimbursement create(Reimbursement entry) 
	{
		return ReimbDAO.createReimb(entry);
	}
	
	public Reimbursement update(Reimbursement entry) 
	{
		return ReimbDAO.updateReimb(entry);
	}
	
	public ArrayList<Reimbursement> getAll()
	{
		return ReimbDAO.getAll();
	}
	
	public ArrayList<Reimbursement> getByStatus(int id)
	{
		return ReimbDAO.getByType(id);
	}
}
