package com.rev.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static ConnectionFactory cf = null;
	private static boolean build = true;
	
	private ConnectionFactory() {
		build = false;
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if (build) {
			cf = new ConnectionFactory();
		}
		
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader(new File("D:/sts-workspace/bankingapp-zachac/src/main/resources/application.properties")));
			Class.forName(prop.getProperty("driver")).newInstance();
			
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("usr"),
					prop.getProperty("pwd"));
			
		} catch (IOException |
				ClassNotFoundException |
				InstantiationException |
				IllegalAccessException |
				SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
