package com.rev.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import com.rev.service.User;
import com.rev.service.User.Data;

public class UserDAO {

	private static UserDAO instance;
	private static final String DIR = "users/";
	
	private UserDAO() { }
	
	public static synchronized UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		
		return instance;
	}
	
	public synchronized boolean exists(String id) {
		return new File(DIR +id).exists();
	}
	
	public synchronized String getCredentials(String id) throws FileNotFoundException {
		
		Scanner s = new Scanner(new File(DIR +id));
		
		while (s.hasNextLine()) {
			String[] values = s.nextLine().split(" ");
			
			if (values[0].equals("password")) {
				s.close();
				return values[1];
			}
		}
		
		s.close();

		throw new IllegalStateException();
	}

	public synchronized void write(User user) {
		
		PrintStream out;
		
		try {
			out = new PrintStream(new File(DIR +user.getID()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		out.printf("%s %s\n", "email", user.getEmail());
		out.printf("%s %s\n", "firstName", user.getFirstName());
		out.printf("%s %s\n", "lastName", user.getLastName());
		out.printf("%s %s\n", "password", user.getPassword());
		out.printf("%s %s\n", "balance", Long.toString(user.getBalance()));
		
		out.close();
	}
	
	public synchronized Data getData(String id) throws FileNotFoundException {
		Scanner s = new Scanner(new File(DIR +id));
		
		String email = null;
		String firstName = null;
		String lastName = null;
		String password = null;
		long balance = -1;
		
		boolean error = false;
		
		while (s.hasNextLine() && !error) {
			String[] values = s.nextLine().split(" ");
			
			switch(values[0]) {
			case "email":
				if (email != null) {
					error = true;
				}
				
				email = values[1];
				break;
			case "firstName":
				if (firstName != null) {
					error = true;
				}
				
				firstName = values[1];
				break;
			case "lastName":
				if (lastName != null) {
					error = true;
				}
				
				lastName = values[1];
				break;
			case "password":
				if (password != null) {
					error = true;
				}
				
				password = values[1];
				break;
			case "balance":
				if (balance != -1) {
					error = true;
				}
				
				balance = Long.parseLong(values[1]);
				break;
			default:
				error = true;
			}
		}
		
		s.close();
		
		if (error || email == null || firstName == null || lastName == null || password == null || balance == -1) {
			throw new IllegalStateException();
		}
		
		return new User.Data(email, firstName, lastName, password, balance);
	}
	
}
