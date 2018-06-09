package com.Project1.service;

import java.util.ArrayList;
import java.util.Optional;

import com.Project1.dao.ReimbDao;
import com.Project1.pojos.Reimb;

public class ReimbServices {

	static ReimbDao ReimbDao = new ReimbDao();
	ArrayList<Reimb> allReimbs = (ArrayList<Reimb>) getAll();
	
	
	public ArrayList<Reimb> getAll(){
		return ReimbDao.getAll();
	}
	public ReimbServices() { allReimbs = getAll();}
	
	public void update(Reimb u) {
		ReimbDao.update(u);
	}
	
	public Reimb addReimb(Reimb u) {
		return ReimbDao.save(u);
	}
	
	public ArrayList<Reimb> getById(int id) {
		ArrayList<Reimb>temp = new ArrayList<Reimb>();
		temp = ReimbDao.getByID(id);
		return temp;
	}	

	public Reimb getByReimbId(int id) {
		return ReimbDao.getByReimbId(id);
	}
}
