package com.bk.service;

import com.bk.dao.DAO;
import com.bk.pojos.Access;
import com.bk.pojos.Account;
import com.bk.pojos.User;

public class Portal extends Access implements indicator {
	boolean isLogin() {
		if (status) {
			return true;
		} else {
			return false;
		}
	};

	int Logout() {

		return INACTIVE;
	};

	public Access Login(Access user) {
		DAO dataAccessTable = new DAO();
		Access usrAccess = dataAccessTable.getAccessByPass(user.getUsername(),user.password);
		if (usrAccess.getId() != -1) {
			usrAccess.setStatus(true);
			user.setUserId(usrAccess.getId());
		}
		return user;

	}
	public Access Login(String usr,String psswrd) {
		DAO dataAccessTable = new DAO();
		Access usrAccess = dataAccessTable.getAccessByPass(usr, psswrd);
		if (usrAccess.getId() != -1) {
			usrAccess.setStatus(true);
		}
		return usrAccess;

	}
  
	public int registerUser(Access user, Account newacc) {
		DAO userDAO = new DAO();
	 
		user=userDAO.saveAccess(user);
		user=Login(user);
		return userDAO.saveUserInfo(userDAO.newAccount(user, newacc.getBalance(), newacc.getTypeid()),user);
		 
	}


}
