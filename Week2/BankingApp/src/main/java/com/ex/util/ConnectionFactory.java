package com.ex.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory 
{
	/*use this class to generate connections to DB
	 * leverages the app.properties file for its credentials
	 */
	
	private static ConnectionFactory cf = null;
	private static Boolean build = true;
	private ConnectionFactory()
	{
		build = false;
		
	}
	
	public static synchronized ConnectionFactory getInstance()
	{
		if(build) cf = new ConnectionFactory();
		
		return cf;
	}
	
	//need a cf to make connection
	public Connection getConnection()
	{
		Connection con = null;
		
		Properties prop = new Properties();
		String path = "C:/Users/Owner/Documents/workspace-sts-3.9.4.RELEASE/BankingApp/src/main/resources/application.properties";
		
		try {
			prop.load(new FileReader(path));
			Class.forName(prop.getProperty("driver"));
			
			con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
}
