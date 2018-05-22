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

		ArrayList<Account> accounts = new ArrayList<Account>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);
			String query = "SELECT * FROM Account WHERE AccountUser_FK = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Account temp = new Account(
						rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4));

				String query2 = "SELECT AccountType FROM Account_Type WHERE AccountTypeId = ?";
				PreparedStatement ps2 = conn.prepareStatement(query2);
				ps2.setInt(1, temp.getTypeId());
				ResultSet rs2 = ps2.executeQuery();
				if (rs2.next())
					temp.setType(rs2.getString(1));
				accounts.add(temp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return accounts;
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
