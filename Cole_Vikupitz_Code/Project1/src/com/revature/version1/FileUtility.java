/*
 * FileUtility.java
 * Author: Cole Vikupitz
 *
 * Contains functions useful for reading and writing user account bank
 * records to file(s).
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

	/**
	 * Reads from the specified file and attempts to parse its data into user
	 * records. Returns an array of all user records successfully parsed from
	 * the data file.
	 *
	 * @param filePath - The file (including path) to read and parse from.
	 * @return Array of successfully parsed user records.
	 */
	protected static User[] loadData(String filePath) {

		// Attempt to open the specified file
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

			// Keep array list to store successfully parsed user records
			ArrayList<User> users = new ArrayList<User>();
			String line = null;
			// Read each line in the file, try to parse user record data
			while ((line = reader.readLine()) != null) {
				// Data fields separated by ':'
				String[] entry = line.split(":");
				try {
					// Add user record to the list
					users.add(new User(entry[0], entry[1], Double.parseDouble(entry[2])));
				} catch(ArrayIndexOutOfBoundsException e) {
					// Failed to parse - bad line; skip over record
				} catch (NumberFormatException e) {
					// Failed to parse - balance invalid; skip over record
				}
			}
			return users.toArray(new User[users.size()]);

		} catch(IOException e) {
			// File could not be read, return null instead
			return null;
		}
	}

	/**
	 * Writes all user records from the array 'users' into the specified
	 * data file.
	 *
	 * @param users - Array of user records to write to file.
	 * @param filePath - The file (including path) to write the records to.
	 */
	protected static void saveData(User[] users, String filePath) {

		// Attempt to write all user records onto specified file
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			// Write each user record into file in specific format
			for (User user : users)
				writer.write(String.format("%s:%s:%.2f\n",
						user.getUsername(), user.getPassword(), user.getBalance()));
		} catch(IOException e) {
			// Failed to write to file for some reason; do nothing
		}

	}
}
