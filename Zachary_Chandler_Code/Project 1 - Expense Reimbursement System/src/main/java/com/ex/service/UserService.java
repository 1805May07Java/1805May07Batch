package com.ex.service;

import org.apache.log4j.Logger;

import com.ex.dao.UserDAO;
import com.ex.dao.UserDAOImpl;
import com.ex.pojo.User;
import com.ex.servlets.LoginServlet;
import com.ex.utility.Hash;

public class UserService {

	private static UserDAO dao = new UserDAOImpl();
	final static Logger logger = Logger.getLogger(LoginServlet.class);
	
	public static User login(String username, String password) {
		
		User u = dao.login(username, Hash.hash(username, password));
		
		if (u != null) {			
			logger.info(String.format("%S has logged in.", username));
		}
		
		return u;
	}
	
}
