package com.rev.service;

import java.util.ArrayList;

import com.rev.dao.ReimburseDAO;
import com.rev.dao.ReimburseDAOImpl;
import com.rev.dao.UserDAO;
import com.rev.dao.UserDAOImpl;
import com.rev.pojos.ReimAll;
import com.rev.pojos.ReimTypes;
import com.rev.pojos.Reimburse;

public class ReimburseService {

	public boolean add(Reimburse r) {
		boolean t = true;
		ReimburseDAO dao = new ReimburseDAOImpl();
		Reimburse q = dao.addReimb(r);
		if (q == null) {
			t = false;
		}
		return t;
	}

	public ArrayList<ReimTypes> getReimTypes() {
		ReimburseDAO dao = new ReimburseDAOImpl();
		ArrayList<ReimTypes> r = dao.getAllReimbTypes();
		return r;
		
	}

	public ArrayList<ReimAll> getAllReimb() {
		ReimburseDAO dao = new ReimburseDAOImpl();
		UserDAO dao2 = new UserDAOImpl();
		ArrayList<Reimburse> r = dao.getAllReimb();
		ArrayList<ReimAll> q = new ArrayList<ReimAll>();
		for (int i = 0; i < r.size(); i++) {
			ReimAll a = new ReimAll(r.get(i).getReimId(), r.get(i).getReimAmmount(), r.get(i).getDateSub(), 
					(r.get(i).getDateRes() == null ? "" : r.get(i).getDateRes()), 
					r.get(i).getNotes(), dao2.getUser(r.get(i).getAuthor()).getUserName(), 
					(r.get(i).getResolver() == 0 ? "" : dao2.getUser(r.get(i).getResolver()).getUserName()),
					dao.getStatus(r.get(i).getStatus()), dao.getType(r.get(i).getType()));
			q.add(a);
			
		}
		
		return q;
	}

	public ArrayList<ReimAll> getAllReimb(int userID) {
		ReimburseDAO dao = new ReimburseDAOImpl();
		UserDAO dao2 = new UserDAOImpl();
		ArrayList<Reimburse> r = dao.getAllReimb(userID);
		ArrayList<ReimAll> q = new ArrayList<ReimAll>();
		for (int i = 0; i < r.size(); i++) {
			ReimAll a = new ReimAll(r.get(i).getReimId(), r.get(i).getReimAmmount(), r.get(i).getDateSub(), 
					(r.get(i).getDateRes() == null ? "" : r.get(i).getDateRes()), 
					r.get(i).getNotes(), dao2.getUser(r.get(i).getAuthor()).getUserName(), 
					(r.get(i).getResolver() == 0 ? "" : dao2.getUser(r.get(i).getResolver()).getUserName()),
					dao.getStatus(r.get(i).getStatus()), dao.getType(r.get(i).getType()));
			q.add(a);
			
		}
		
		return q;
	}

	public ArrayList<ReimAll> getAprReimb() {
		ReimburseDAO dao = new ReimburseDAOImpl();
		UserDAO dao2 = new UserDAOImpl();
		ArrayList<Reimburse> r = dao.getAprReim();
		ArrayList<ReimAll> q = new ArrayList<ReimAll>();
		for (int i = 0; i < r.size(); i++) {
			ReimAll a = new ReimAll(r.get(i).getReimId(), r.get(i).getReimAmmount(), r.get(i).getDateSub(), 
					(r.get(i).getDateRes() == null ? "" : r.get(i).getDateRes()), 
					r.get(i).getNotes(), dao2.getUser(r.get(i).getAuthor()).getUserName(), 
					(r.get(i).getResolver() == 0 ? "" : dao2.getUser(r.get(i).getResolver()).getUserName()),
					dao.getStatus(r.get(i).getStatus()), dao.getType(r.get(i).getType()));
			q.add(a);
			
		}
		
		return q;
	}

	public ArrayList<ReimAll> getDenReimb() {
		ReimburseDAO dao = new ReimburseDAOImpl();
		UserDAO dao2 = new UserDAOImpl();
		ArrayList<Reimburse> r = dao.getDenReim();
		ArrayList<ReimAll> q = new ArrayList<ReimAll>();
		for (int i = 0; i < r.size(); i++) {
			ReimAll a = new ReimAll(r.get(i).getReimId(), r.get(i).getReimAmmount(), r.get(i).getDateSub(), 
					(r.get(i).getDateRes() == null ? "" : r.get(i).getDateRes()), 
					r.get(i).getNotes(), dao2.getUser(r.get(i).getAuthor()).getUserName(), 
					(r.get(i).getResolver() == 0 ? "" : dao2.getUser(r.get(i).getResolver()).getUserName()),
					dao.getStatus(r.get(i).getStatus()), dao.getType(r.get(i).getType()));
			q.add(a);
			
		}
		
		return q;
	}

	public ArrayList<ReimAll> getPendReimb() {
		ReimburseDAO dao = new ReimburseDAOImpl();
		UserDAO dao2 = new UserDAOImpl();
		ArrayList<Reimburse> r = dao.getPendReim();
		ArrayList<ReimAll> q = new ArrayList<ReimAll>();
		for (int i = 0; i < r.size(); i++) {
			ReimAll a = new ReimAll(r.get(i).getReimId(), r.get(i).getReimAmmount(), r.get(i).getDateSub(), 
					(r.get(i).getDateRes() == null ? "" : r.get(i).getDateRes()), 
					r.get(i).getNotes(), dao2.getUser(r.get(i).getAuthor()).getUserName(), 
					(r.get(i).getResolver() == 0 ? "" : dao2.getUser(r.get(i).getResolver()).getUserName()),
					dao.getStatus(r.get(i).getStatus()), dao.getType(r.get(i).getType()));
			q.add(a);
			
		}
		
		return q;
	}

	public void updateStat(int id, int status, int person) {
		ReimburseDAO dao = new ReimburseDAOImpl();
		dao.updateReimb(id, status, person);
		
	}

}
