package com.ex.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static ConnectionFactory cf = null;
	private static Boolean build = true;
	private ConnectionFactory() {
		build = false;
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if(build) cf = new ConnectionFactory();
		return cf;
	}
	// need a cf to make connection:
	public Connection getConnection() {
		Connection conn = null;
		
        Properties prop = new Properties();
        /*
        *
        *   ADD PROPER PATH BELOW *****************
        *
        */
		String path = "G:/My Drive/Revature/Workspace-STS/Proj0Bank/src/main/resources/application.properties";   
		try {
			prop.load(new FileReader(path));
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("pwd"));
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
}