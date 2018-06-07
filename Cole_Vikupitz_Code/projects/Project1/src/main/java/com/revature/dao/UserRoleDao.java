/*
 * UserRoleDao.java
 * Author: Cole Vikupitz
 */

package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.UserRole;
import com.revature.util.ConnectionFactory;

public class UserRoleDao {

	public static List<UserRole> getAll() {

		List<UserRole> list = new ArrayList<UserRole>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM User_Role";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				UserRole temp = new UserRole(rs.getInt(1), rs.getString(2));
				list.add(temp);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static UserRole getById(int id) {

		UserRole temp = new UserRole();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String sql = "SELECT * FROM User_Role WHERE UserRoleId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();

			if (info.next()) {
				temp.setId(info.getInt(1));
				temp.setRole(info.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;
	}

}
