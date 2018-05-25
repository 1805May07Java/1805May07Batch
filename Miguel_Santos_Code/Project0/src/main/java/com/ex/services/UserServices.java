package com.ex.services;

import com.ex.dao.UserDao;

public class UserServices {
	UserDao udao = new UserDao();

	public boolean isTaken(String un) {
		if (udao.isTaken(un) == 1) return true;
		else return false;
	}

	public void addUser(String fn, String ln, String un, String pw) {
		udao.addUser(fn, ln, un, pw);
	}

	public boolean validUnPw(String un, String pw) {
		if (udao.validUnPw(un, pw) == 1) return true;
		else return false;
	}

	public int findIdByUsername(String un) {
		return udao.findIdByUsername(un);
	}

	public void updatePw(int id, String pw) {
		udao.updatePw(id, pw);
		
	}
	
	
}
