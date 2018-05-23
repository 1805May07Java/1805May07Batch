package com.Banking.service;

import java.util.ArrayList;
import java.util.List;
import com.Banking.dao.AccountDao;
import com.Banking.dao.SavingsDao;
import com.Banking.dao.Dao;
import com.Banking.dao.SavingsDao;
import com.Banking.pojos.Account;
import com.Banking.pojos.Savings;

public class SavingsService {

		
		static Dao<Savings, Integer> savingsDao = (Dao<Savings, Integer>) new SavingsDao();
		ArrayList<Savings> allAccounts = (ArrayList<Savings>) getAllAccounts();
		
		public SavingsService() {}
		
		public void update(Savings a) {
			savingsDao.update(a);
		}

		public List<Savings> getAllAccounts(){
			return savingsDao.getAll();
		}

		public Savings addSavings(Savings b){
			return savingsDao.save(b);
		}

		public Savings getById(int id) {
			return savingsDao.findOne(id);
		}
		
		public boolean exists(int id) {
			boolean exists = false;
			for(Savings c: allAccounts) {
				if(c.getAccountID() == id) {
					exists = true;
				}
			}
			return exists;
		}
	}

