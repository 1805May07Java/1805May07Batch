/*
 * UserDao.java
 * Author: Cole Vikupitz
 */

package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;

public class UserDao {

	public static User getUser(String email, String password) {

		User temp = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM Users WHERE Email = ? AND Password_ = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet info = ps.executeQuery();

			if (info.next()) {
				temp = new User();
				temp.setId(info.getInt(1));
				temp.setFirstName(info.getString(2));
				temp.setLastname(info.getString(3));
				temp.setEmail(info.getString(4));
				temp.setPassword(info.getString(5));
				temp.setRoleId(info.getInt(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;
	}
}
