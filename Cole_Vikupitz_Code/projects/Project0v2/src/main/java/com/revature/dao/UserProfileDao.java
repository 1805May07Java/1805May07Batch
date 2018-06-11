/*
 * UserDao.java
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

import com.revature.pojos.UserProfile;
import com.revature.util.ConnectionFactory;

public class UserProfileDao {

	// Returns true/false depending on if the username is unique
	public static boolean usernameUnique(String username) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);
			// Prepare query, create statement object, pass in params
			String query = "SELECT * FROM User_Profile WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			// Execute query, check if there is a result
			ResultSet rs = ps.executeQuery();

			return !rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	// Returns an instance of a UserRecord, given a username & password
	// Returns instance if such a profile exists, null if not
	public static UserProfile authenticate(String username, String password) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);
			// Prepare query, create prepared statement object,pass in params
			String query = "SELECT * FROM User_Profile WHERE Username = ? AND Password_ = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			// Execute query, obtain result(s)
			ResultSet rs = ps.executeQuery();

			if (!rs.next())
				return null;
			// Create the profile record, return it
			return new UserProfile(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5)
			);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// Adds the specified user profile record to the database
	// All changes are committed to the database
	public static void addUserRecord(UserProfile user) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			conn.setAutoCommit(false);
			// Prepare the query, create prepared statement object
			String query = "INSERT INTO User_Profile (FirstName, LastName, Username, Password_) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			// Pass in params
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());

			// Execute the query, commit the changes
			ps.executeQuery();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Returns an array list of all the user profile records from the database
	public ArrayList<UserProfile> getAllProfiles() {

		ArrayList<UserProfile> profiles = new ArrayList<UserProfile>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			// Prepare the query, create the statement object
			String query = "SELECT * FROM User_Profile";
			Statement ps = conn.createStatement();
			// Obtain the result set
			ResultSet rs = ps.executeQuery(query);

			while(rs.next())
				// Add each user profile to the array list
				profiles.add(new UserProfile(
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5))
				);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return profiles;
	}

}
