package com.ex.dao;
import com.ex.pojos.Reimbursement;
import com.ex.pojos.User;

import java.util.ArrayList;
import java.util.List;

public interface ReimbursementDao {
	public Reimbursement insertReimbursement(Reimbursement re);
	public Reimbursement getReimbursement(int id);
	public boolean updateReimbursement(Reimbursement re);
	public List<Reimbursement> getAllReimbursements();
	public List<Reimbursement> getAllSubmitted();
	public List<Reimbursement> getAllResolved();
	public List<Reimbursement> getAllSubmittedForU(User usr);
	public List<Reimbursement> getAllResolvedForU(User usr);
	public ArrayList<Reimbursement> getUserReimbursements(int userId);
}
