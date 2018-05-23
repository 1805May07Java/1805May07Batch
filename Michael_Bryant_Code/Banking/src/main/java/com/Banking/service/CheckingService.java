package com.Banking.service;

import java.util.ArrayList;
import java.util.List;
import com.Banking.dao.AccountDao;
import com.Banking.dao.CheckingDao;
import com.Banking.dao.Dao;
import com.Banking.pojos.Account;
import com.Banking.pojos.Checking;

public class CheckingService {

		
		static Dao<Checking, Integer> checkingDao = new CheckingDao();
		ArrayList<Checking> allAccounts = (ArrayList<Checking>) getAllAccounts();
		
		public CheckingService() {}
		
		public void update(Checking a) {
			checkingDao.update(a);
		}

		public List<Checking> getAllAccounts(){
			return checkingDao.getAll();
		}

		public Checking addChecking(Checking b){
			return checkingDao.save(b);
		}

		public Checking getById(int id) {
			return checkingDao.findOne(id);
		}
		
		public boolean exists(int id) {
			boolean exists = false;
			for(Checking c: allAccounts) {
				if(c.getAccountID() == id) {
					exists = true;
				}
			}
			return exists;
		}
	}

