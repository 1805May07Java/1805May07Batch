package com.ex.service;

import java.util.UUID;

import com.ex.dao.UserDAO;
import com.ex.pojo.User;

public class UserService {
	
	static UserDAO dao = new UserDAO();
	
	public static void makeNewUser(UUID userid, String uname, String pwd, String fname, String lname) {
		User user = new User(userid, uname, pwd, fname, lname);
		dao.save(user);
	}
	
	public static boolean confirmLogin(String uname, String pwd) {
				
		return dao.confirmLogin(uname,pwd);
	}
	
	public static UUID getUserId(String uname, String pwd) {
		return dao.getUserId(uname, pwd);
	}

}
