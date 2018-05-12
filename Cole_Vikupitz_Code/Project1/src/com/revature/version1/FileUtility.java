/*
 * FileUtility.java
 * Author: Cole Vikupitz
 *
 * FIXME - ADD DESCRIPTION
 */

package com.revature.version1;

// Imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtility {

	// File path to save data to
	protected static final String FILE = "src/com/revature/version1/database.txt";

	/***/
	protected static User[] loadData(String filePath) {

		try(BufferedReader reader = new BufferedReader(new FileReader(filePath));) {

			ArrayList<User> users = new ArrayList<User>();
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] entry = line.split(":");
				try {
					users.add(new User(entry[0], entry[1], Double.parseDouble(entry[2])));
				} catch(ArrayIndexOutOfBoundsException e) {
					//FIXME what should happen here?
				}
			}

			return users.toArray(new User[users.size()]);
		} catch(IOException e) {
			// FIXME - what should happen here?
			return null;
		}
	}

	/***/
	protected static void saveData(User[] users, String filePath) {

		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));) {
			for (User user : users)
				writer.write(String.format("%s:%s:%.2f",
						user.getUsername(), user.getPassword(), user.getBalance()));
		} catch(IOException e) {
			// FIXME - what should happen here?
		}

	}
}
