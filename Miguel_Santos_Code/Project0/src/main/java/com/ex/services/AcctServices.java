package com.ex.services;

import java.util.ArrayList;

import com.ex.dao.AcctDao;

public class AcctServices {
	AcctDao adao = new AcctDao();

	public int numOfAccts(int id) {
		return adao.numOfAccts(id);
	}

	public void getAcctBal(int id) {
		ArrayList<String> values = new ArrayList<String>();
		values = adao.getAcctBals(id);
		for(String s: values)
			System.out.println(s);
	}

	public void addAccount(int id, int select) {
		adao.addAccount(id, select);
	}

	public void deposit(double amt, int id, int select) {
		double total = adao.getBalance(id, select) + amt;
		adao.updateBal(total, id, select);
	}

	public double getBalance(int id, int select) {
		return adao.getBalance(id, select);
	}

	public void withdraw(double amt, int id, int select) {
		double total = adao.getBalance(id, select) - amt;
		adao.updateBal(total, id, select);
	}

	public boolean hasAccount(int id, int select) {
		return adao.hasAccount(id, select);
	}

	public void transfer(double amt, int id, int sel1, int sel2) {
		double tot1 = adao.getBalance(id, sel1) - amt;
		double tot2 = adao.getBalance(id, sel2) + amt;
		adao.updateBal(tot1, id, sel1);
		adao.updateBal(tot2, id, sel2);
	}
	
	
}
