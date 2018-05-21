/*
 * UserDao.java
 * Author: Cole Vikupitz
 *
 */

package com.revature.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.pojos.UserProfile;
import com.revature.util.ConnectionFactory;

public class UserProfileDao {

	public static boolean usernameUnique(String username) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static UserProfile authenticate(String username, String password) {
		return null;
	}

}
