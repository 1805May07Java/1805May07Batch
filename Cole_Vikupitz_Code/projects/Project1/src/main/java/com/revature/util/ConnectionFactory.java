/*
 * ConnectionFactory.java
 * Author: Cole Vikupitz
 *
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

	private ConnectionFactory() { /* Nothing to be done... */ }

	public static synchronized ConnectionFactory getInstance() {
		if (instance == null)
			instance = new ConnectionFactory();
		return instance;
	}

	public Connection getConnection() {

		Connection conn = null;

		Properties prop = new Properties();
		//String path = "src/main/resources/application.properties";
		String path = "C:/Users/Cole/Desktop/Project1/src/main/resources/application.properties";
		try {
			prop.load(new FileReader(path));
			Class.forName(prop.getProperty("driver"));

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
