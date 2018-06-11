/*
 * AccountDao.java
 * Author: Cole Vikupitz
 *
 */

package com.revature.dao;

// Imports
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.pojos.Account;
import com.revature.util.ConnectionFactory;

public class AccountDao {


	// Returns an arraylist of all account records belonging to the specified user
	// The user referred here is by their primary key
	public static ArrayList<Account> getUserAccounts(int id) {

		ArrayList<Account> accounts = new ArrayList<Account>();

		// Set up connection with the database
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);
			// Prepare query, pass in params
			String query = "SELECT * FROM Account WHERE AccountUser_FK = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			// Execute the query, retrieve result set of all records
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				// Create the account object
				Account temp = new Account(
						rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4));
				// We need to also get the account type in string format
				// Execute another query, retrieve from the account type table
				String query2 = "SELECT AccountType FROM Account_Type WHERE AccountTypeId = ?";
				// Create prepared statement object, pass in params
				PreparedStatement ps2 = conn.prepareStatement(query2);
				ps2.setInt(1, temp.getTypeId());
				// Execute query, retrieve result, update record
				ResultSet rs2 = ps2.executeQuery();
				if (rs2.next())
					temp.setType(rs2.getString(1));
				// Add new account record into array list
				accounts.add(temp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return accounts;
	}

	// Returns the string of the specified account type
	// The type referred is the primary key in the account type table
	protected static String getAccountType(int id) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			// Set up query, pass in params
			conn.setAutoCommit(false);
			String query = "SELECT AccountType FROM Account_Type WHERE AccountTypeId = ?";
			// Create the prepared statement object
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			// Execute query, obtain the result
			ResultSet rs = ps.executeQuery();

			return (rs.next()) ? rs.getString(1) : "";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	// Updates the specified account record in the database
	// Uses a callable statement; executes a stored procedure
	public static void updateAccount(Account account) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			// Set up the query, create the callable statement, pass in params
			String query = "{call updateBalance(?, ?)}";
			CallableStatement cs = conn.prepareCall(query);
			cs.setInt(1, account.getId());
			cs.setDouble(2, account.getBalance());
			// Execute the query
			cs.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Adds the specified account record into the database, commits the change
	public static void addAccountRecord(int userFk, int type) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			/// Set up the query, set up parameters
			conn.setAutoCommit(false);
			String query = "INSERT INTO Account (AccountUser_FK, AccountType_FK) VALUES (?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, userFk);
			ps.setInt(2, type);
			// Execute the query, commit changes to database
			ps.executeQuery();
			conn.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Returns an array list of all the account records from the database
	public ArrayList<Account> getAllAccounts() {

		ArrayList<Account> accounts = new ArrayList<Account>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			// Execute the query, get the result set
			String query = "SELECT * FROM Account";
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(query);

			// Add each record into arraylist
			while(rs.next())
				accounts.add(new Account(
						rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4))
				);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return accounts;
	}

}
