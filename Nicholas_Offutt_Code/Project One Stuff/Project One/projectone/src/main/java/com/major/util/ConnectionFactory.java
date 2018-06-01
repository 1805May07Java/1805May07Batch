package com.major.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory 
{
	/*We use this class to generate 
	 * connections to our database.
	 * It leverages the app.properties file 
	 * for its connections. 
	 */
	
	//using lazy instantiation singleton implementation
	private static ConnectionFactory cf = null;
	private static Boolean build = true;
	
	//private constructor
	private ConnectionFactory() 
	{
		build =false;
	}
	
	//allows others to obtain our connection 
	public static synchronized ConnectionFactory getInstance() 
	{
		//checks build first
		if(build) 
		{
			cf = new ConnectionFactory();
		}
		
		//returns our object
		return cf;
	}
	
	
	//need an instance to make connection, this sets up what is needed to access the database
	public Connection getConnection() 
	{
		Connection conn = null;
		
		Properties prop = new Properties();
		String path = "C:/Users/nicho/Documents/WorkspaceWeek2/projzero/src/main/resources/application.properties";
		
		
		//being risky
		try 
		{
			//loading our properties file 
			prop.load(new FileReader(path));
			//obtaining the appropriate  driver
			Class.forName(prop.getProperty("driver"));
			//loading up our connection and credentials
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("pwd"));
					
		} //handling everything that can go wrong
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
}