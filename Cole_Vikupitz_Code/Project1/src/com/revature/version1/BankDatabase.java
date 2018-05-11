/*
 * BankDatabase.java
 * Author: Cole Vikupitz
 *
 * FIXME - ADD DESCRIPTION
 */

package com.revature.version1;

// Imports
import java.util.HashMap;

public class BankDatabase {

	private static BankDatabase instance = null;
	private HashMap<String, User> map;

	private BankDatabase() {

		this.map = new HashMap<String, User>();
	}

	public static BankDatabase getInstance() {

		if (instance == null)
			instance = new BankDatabase();
		return instance;
	}

	public void addUser(User user) {

		this.map.put(user.getUsername(), user);
	}

	public boolean userNameExists(String username) {

		return instance.map.containsKey(username);
	}

	public User authenticate(String username, String password) {

		User user = instance.map.get(username);
		if (user == null)
			return null;
		if (!user.getPassword().equals(password))
			return null;
		return user;
	}

	public void saveDBtoFile(String filePath) {

		User[] users = (User[]) instance.map.values().toArray();
		FileUtility.saveData(users, filePath);
	}

	public void loadDBfromFile(String filePath) {

		User[] users = FileUtility.loadData(filePath);
		for (User user : users)
			instance.map.put(user.getUsername(), user);
	}

}
