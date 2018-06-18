package com.Banking.service;

import java.util.ArrayList;
import java.util.List;

import com.Banking.dao.CreditDao;
import com.Banking.dao.Dao;
import com.Banking.pojos.Credit;

public class CreditService {

		
		static Dao<Credit, Integer> CreditDao = (Dao<Credit, Integer>) new CreditDao();
		ArrayList<Credit> allAccounts = (ArrayList<Credit>) getAllAccounts();
		
		public CreditService() {}
		
		public void update(Credit a) {
			CreditDao.update(a);
		}

		public List<Credit> getAllAccounts(){
			return CreditDao.getAll();
		}

		public Credit addCredit(Credit b){
			return CreditDao.save(b);
		}

		public Credit getById(int id) {
			return CreditDao.findOne(id);
		}
		
		public boolean exists(int id) {
			boolean exists = false;
			allAccounts = (ArrayList<Credit>) getAllAccounts();
			for(Credit c: allAccounts) {
				if(c.getAccountID() == id) {
					exists = true;
				}
			}
			return exists;
		}
	}

