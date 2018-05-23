package com.ex.service;

import java.util.UUID;

import com.ex.dao.Account_UserDAO;
import com.ex.pojo.Account_User;

public class Account_UserService {
	static Account_UserDAO dao = new Account_UserDAO();
	
	public static void makeNewAccount_User(UUID accountid, UUID userid) {
		Account_User au = new Account_User(accountid, userid);
		
		dao.save(au);
				
	}
	
	public static UUID getAccountId(UUID userid) {
		return dao.getAccountId(userid);
	}

}
