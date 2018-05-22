/*
 * AccountDao.java
 * Author: Cole Vikupitz
 *
 */

package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.pojos.Account;
import com.revature.util.ConnectionFactory;

public class AccountDao {

	public static ArrayList<Account> getUserAccounts(int id) {

		ArrayList<Account> list = new ArrayList<Account>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);
			String query = "SELECT * FROM Account WHERE AccountUser_FK = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// FIXME
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	protected String getAccountType(int id) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);
			String query = "SELECT AccountType FROM Account_Type WHERE AccountTypeId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			return (rs.next()) ? rs.getString(1) : "";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

}
