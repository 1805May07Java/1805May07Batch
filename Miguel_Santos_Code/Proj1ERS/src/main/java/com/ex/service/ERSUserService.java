package com.ex.service;

import com.ex.dao.UserDao;
import com.ex.pojos.ERSUser;

public class ERSUserService {
	UserDao udao = new UserDao();

	public ERSUser validUnPw(String un, String pw) {
		if(udao.validUnPw(un, pw) == 1) {
			return udao.getByUsername(un);
		}
		else return null;
	}

	
	
}
