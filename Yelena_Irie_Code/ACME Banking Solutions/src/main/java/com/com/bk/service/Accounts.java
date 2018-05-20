package com.bk.service;
import com.bk.dao.DAO;
import com.bk.pojos.Access;
import com.bk.pojos.Account;
public class Accounts extends Account {
	
	
	public int createAccount(Access login) {
		//Create Account
		DAO accDAO = new DAO();
	  
	    accDAO.newAccountByInt(login);
	    
		return Account.getId();
	}
}
