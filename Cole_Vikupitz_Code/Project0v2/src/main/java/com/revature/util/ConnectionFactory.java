/*
 * ConnectionFactory.java
 * Author: Cole Vikupitz
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

	private static ConnectionFactory instance = null;

	private ConnectionFactory() {}

	public static synchronized ConnectionFactory getInstance() {

		if(instance == null)
			instance = new ConnectionFactory();
		return instance;
	}

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
