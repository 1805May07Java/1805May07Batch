package com.major.Daos;

import java.util.ArrayList;

import com.major.pojos.ErsUser;
import com.major.pojos.Reimbursement;

public interface ReimbDao 
{
	public Reimbursement getById(int id);
	public ArrayList<Reimbursement> getByType(int typeId);
	public ArrayList<Reimbursement> getByAuthor(ErsUser obj);
	public ArrayList<Reimbursement> getByResolver(ErsUser obj);
	public Reimbursement createReimb(Reimbursement obj);
	public Reimbursement updateReimb(Reimbursement obj);
	public ArrayList<Reimbursement> getAll();
}
