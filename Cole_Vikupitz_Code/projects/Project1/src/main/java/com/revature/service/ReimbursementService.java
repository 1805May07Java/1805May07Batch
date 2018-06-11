/*
 * ReimbursementService.java
 * Author: Cole Vikupitz
 *
 */

package com.revature.service;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.pojos.Reimbursement;

public class ReimbursementService {

	public static List<Reimbursement> getAllResolved(int id) {

		return ReimbursementDao.getAllResolved(id);
	}

	public static List<Reimbursement> getAllPending(int id) {

		return ReimbursementDao.getAllPending(id);
	}

	public static List<Reimbursement> getAllResolved() {

		return ReimbursementDao.getAllResolved();
	}

	public static List<Reimbursement> getAllPending() {

		return ReimbursementDao.getAllPending();
	}

	public static void addRequest(Reimbursement re) {

		ReimbursementDao.addReimbursement(re);
	}

	public static void update(Reimbursement re) {

		ReimbursementDao.update(re);
	}

}
