/*
 * StatusDao.java
 * Author: Cole Vikupitz
 *
 */

package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Status;
import com.revature.util.ConnectionFactory;

public class StatusDao {

	public static List<Status> getAll() {

		List<Status> list = new ArrayList<Status>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM Status";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				Status temp = new Status(rs.getInt(1), rs.getString(2));
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static Status getById(int id) {

		Status temp = new Status();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()){

			String sql = "SELECT * FROM Status WHERE StatusId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();

			if (info.next()) {
				temp.setId(info.getInt(1));
				temp.setStatus(info.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;
	}

}
