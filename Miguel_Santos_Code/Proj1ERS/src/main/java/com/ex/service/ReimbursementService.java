package com.ex.service;

import java.util.ArrayList;

import com.ex.dao.ReimbursementDao;
import com.ex.pojos.Reimbursement;

public class ReimbursementService {
	ReimbursementDao rdao = new ReimbursementDao();

	public ArrayList<Reimbursement> getData(int id, int role) {
		ArrayList<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		if(role == 1) {		//Employee Data
			reimbs = rdao.getById(id);
		}
		else {				//Manager Data
			reimbs = rdao.getAll();
		}
		return reimbs;
	}

	public void addReimbursement(int id, double amount, String description, int type_id) {
		rdao.addReimbursement(id, amount, description, type_id);
		
	}

	public ArrayList<String> getOptions() {
		return rdao.getOptions();		
	}

	public void approveDeny(int user_id, String reimb_id, String string) {
		int approve = Integer.parseInt(string);
		int man_id = Integer.parseInt(reimb_id);
		rdao.approveDeny(user_id, man_id, approve);
		
	}
}
