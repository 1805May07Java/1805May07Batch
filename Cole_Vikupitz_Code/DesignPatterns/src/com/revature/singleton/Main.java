/*
 * Main.java
 * Author: Cole Vikupitz
 * 
 * In software engineering, the singleton pattern is a software design pattern
 * that restricts the instantiation of a class to one object. This is useful when
 * exactly one object is needed to coordinate actions across the system. The concept
 * is sometimes generalized to systems that operate more efficiently when only one
 * object exists, or that restrict the instantiation to a certain number of objects.
 * The term comes from the mathematical concept of a singleton.
 * 
 * There are some who are critical of the singleton pattern and consider it to be an
 * anti-pattern in that it is frequently used in scenarios where it is not beneficial,
 * introduces unnecessary restrictions in situations where a sole instance of a class
 * is not actually required, and introduces global state into an application.
 * 
 * - from Wikipedia (https://en.wikipedia.org/wiki/Singleton_pattern)
 */

package com.revature.singleton;

public class Main {

	public static void main(String[] args) {	
		
		// Should give the same instances
		Server server1 = Server.getInstance();
		Server server2 = Server.getInstance();
		Server server3 = Server.getInstance();
		System.out.printf("server1 == server2 : %s\n", (server1 == server2));
		System.out.printf("server2 == server3 : %s\n", (server2 == server3));
		System.out.printf("server1 == server3 : %s\n", (server1 == server3));
		
		// run() will also print the same thing
		System.out.print("[server1]: ");
		server1.run();
		System.out.print("[server2]: ");
		server2.run();
		System.out.print("[server3]: ");
		server3.run();
	}
}
