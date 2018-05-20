package com.bk.service;
import com.bk.dao.DAO;
import com.bk.pojos.Access;
import com.bk.pojos.Account;
import com.bk.pojos.User;
public class Accounts extends Account{
	
	
   

	public User createAccount(Access login, User customer,String email) {
		// TODO Auto-generated method stub
		//Create Account
		DAO accDAO = new DAO();
	  
	    Account newAcc = accDAO.newAccount(login);
	    //Add Customer Information to the CusotmerTable
	    if(accDAO.newCust(login.status,newAcc.getId(),newAcc.getUserid(),email) !=0) {
	       accDAO.getCustByAccId(newAcc.getId());
	    	
	    };
	     
		return customer;
	}

	public Account getAccount(int accId) {
		// TODO Auto-generated method stub
		DAO accDAO = new DAO();

		return accDAO.getAccByAccID(accId);
	}
	   public Accounts(Access usr_access) {
			// TODO Auto-generated constructor stub
		 setUserid(usr_access.getId());
				   
		}
}
