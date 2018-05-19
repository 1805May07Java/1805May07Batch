package com.bk.pojos;

import com.bk.dao.DAO;

public class Account {
     private int id=-1;
     private int userid=-1;
     private double balance=0.0;
     private String name="";
     
	public int createAccount(Access login) {
		//Create Account
		DAO accDAO = new DAO();
	    login.getId();
	    accDAO.getById(login.getId());
		return -1;
	}

	public void setName(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setBalance(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setUsrId(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setID(int int1) {
		// TODO Auto-generated method stub
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	 

}
