/*
 * UserService.java
 * Author: Cole Vikupitz
 *
 */

package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.pojos.User;

public class UserService {

	public static User authenticate(String email, String password) {

		return UserDao.getUser(email, password);
	}

}
