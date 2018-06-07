/*
 * TypeDao.java
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

import com.revature.pojos.Type;
import com.revature.util.ConnectionFactory;

public class TypeDao {

	public static List<Type> getAll() {

		List<Type> list = new ArrayList<Type>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM Reimb_Type";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				Type temp = new Type(rs.getInt(1), rs.getString(2));
				list.add(temp);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static Type getById(int id) {

		Type temp = new Type();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			String sql = "SELECT * FROM Status WHERE StatusId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();

			if (info.next()) {
				temp.setId(info.getInt(1));
				temp.setName(info.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;
	}

}
