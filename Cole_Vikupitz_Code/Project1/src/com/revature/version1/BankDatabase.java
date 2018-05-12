/*
 * BankDatabase.java
 * Author: Cole Vikupitz
 *
 * Singleton class that represents the database system for all bank
 * records. Users can authenticate, retrieve, save, and load bank records.
 */

package com.revature.version1;

// Imports
import java.util.HashMap;

public class BankDatabase {

	// Single instance of the database
	private static BankDatabase instance = null;
	// Map to store usernames to their corresponding account
	private HashMap<String, User> map;

	// Private constructor
	private BankDatabase() {

		this.map = new HashMap<String, User>();
	}

	/**
	 * Returns the single instance of the bank account database.
	 *
	 * @return The single instance of the bank database.
	 */
	public static BankDatabase getInstance() {

		if (instance == null)
			// Create new instance if not already
			instance = new BankDatabase();
		return instance;
	}

	/**
	 * Adds the specified user 'user' instance record into the database.
	 *
	 * @param user - The user account record to store in the database.
	 */
	public void addUser(User user) {

		this.map.put(user.getUsername(), user);
	}

	/**
	 * Returns true/false depending on if the username 'username' already
	 * exists in the database.
	 *
	 * @param username - The username to check for in the database.
	 * @return True if there exists a record with the specified username,
	 * false if not.
	 */
	public boolean userNameExists(String username) {

		return instance.map.containsKey(username);
	}

	/**
	 * Returns the User record corresponding with the specified username and
	 * password 'username' and 'password', respectively. If the username and
	 * password fail to authenticate, that is, no such user record exists in
	 * the database, null is returned.
	 *
	 * @param username - The username to authenticate.
	 * @param password - The password to check.
	 * @return The User instance with the username and password, null if
	 * authentication failed.
	 */
	public User authenticate(String username, String password) {

		User user = instance.map.get(username);
		// Username does not exist
		if (user == null)
			return null;
		// Username and password don't match
		if (!user.getPassword().equals(password))
			return null;
		return user;
	}

	/**
	 * Saves the user record database to the specified file 'filePath'.
	 *
	 * @param filePath - The file (including path) to save the records to.
	 */
	public void saveDBtoFile(String filePath) {

		int len = this.map.size();
		User[] users = instance.map.values().toArray(new User[len]);
		FileUtility.saveData(users, filePath);
	}

	/**
	 * Loads all user account records into the database from the specified
	 * file 'filePath'.
	 *
	 * @param filePath - The file (including path) to load the records from.
	 */
	public void loadDBfromFile(String filePath) {

		User[] users = FileUtility.loadData(filePath);
		if (users != null)
			for (User user : users)
				instance.map.put(user.getUsername(), user);
	}

}
