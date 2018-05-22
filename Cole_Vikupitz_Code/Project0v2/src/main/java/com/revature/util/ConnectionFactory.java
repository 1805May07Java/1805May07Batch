/*
 * ConnectionFactory.java
 * Author: Cole Vikupitz
 *
 * Class that provides functionality to connect to
 * the bank database.
 */

package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	// Use a singleton design pattern
	// The instance itself
	private static ConnectionFactory instance = null;

	// Private constructor
	private ConnectionFactory() {}

	// Returns the single instance of the connection factory class
	public static synchronized ConnectionFactory getInstance() {

		// Create instance if needed
		if (instance == null)
			instance = new ConnectionFactory();
		return instance;
	}

	// Returns a connection to the database
	public Connection getConnection() {

		Connection conn = null;
		Properties prop = new Properties();
		String path = "C:/Users/Cole/Desktop/1805May07Batch/Cole_Vikupitz_Code/Project0v2/src/main/resources/application.properties";

		try {
			prop.load(new FileReader(path));
			Class.forName(prop.getProperty("driver"));

			/* The DriverManager provides a basic service for managing a
			 * set of JDBC drivers. As part of its initialization, the
			 * DriverManager class will attempt to load the driver classes
			 * referenced in the jdbc.drivers system property
			 */
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("username"),
					prop.getProperty("password"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
}
