/*
 * Server.java
 * Author: Cole Vikupitz
 */

package com.revature.singleton;

public class Server {

	// The single instance to use
	private static Server instance = null;
	
	private String ipAddress;
	private int portNumber;
	private long connectedClients;
	
	// Constructor must be private, forces user to use getInstance()
	// to retrieve single instance of class
	private Server() {
		this.ipAddress = "127.0.0.1";
		this.portNumber = 4000;
		this.connectedClients = 0L;
	}
	
	public static Server getInstance() {
		
		// Create instance if none exists, return it
		if (instance == null)
			instance = new Server();
		return instance;
	}
	
	public String getIPAddress() {
		return this.ipAddress;
	}
	
	public int getPortNumber() {
		return this.portNumber;
	}
	
	public void run() {
		System.out.printf("Running server %s\n", instance.toString());
	}

	public long numberOfClients() {
		return this.connectedClients;
	}
	
	// Other code here...
}
