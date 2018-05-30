package com.ex.service;

import com.ex.dao.ERS_REIMBURSEMENT_STATUS_DAO;

public class ERS_REIMBURSEMENT_STATUS_Service {
	static ERS_REIMBURSEMENT_STATUS_DAO dao = new ERS_REIMBURSEMENT_STATUS_DAO();
	public static String test() {
		return dao.getERS_REIMBURSEMENT_STATUS(2).toString();
	}
}
