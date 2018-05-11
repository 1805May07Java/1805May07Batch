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

	public synchronized void write(User user) {
		
		PrintStream out;
		
		try {
			out = new PrintStream(new File(DIR +user.getID()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		out.printf("%s: %s\n", "email", user.getEmail());
		out.printf("%s: %s\n", "firstName", user.getFirstName());
		out.printf("%s: %s\n", "lastName", user.getLastName());
		out.printf("%s: %s\n", "password", user.getPassword());
		out.printf("%s: %s\n", "balance", Long.toString(user.getBalance()));
		
		out.close();
	}
	
	public synchronized Data getData(String id) throws FileNotFoundException {
		
		Data d = Data.getData(id);
		
		if (d != null) {
			return d;
		}
		
		Scanner s = new Scanner(new File(DIR +id));
		
		String email = null;
		String firstName = null;
		String lastName = null;
		String password = null;
		long balance = -1;
		
		boolean error = false;
		
		while (s.hasNextLine() && !error) {
			String value = s.nextLine();
			int keyPos = value.indexOf(": ");
			String key = value.substring(0, keyPos);
			value = value.substring(keyPos + 2);
			
			switch(key) {
			case "email":
				if (email != null) {
					error = true;
				}
				
				email = value;
				break;
			case "firstName":
				if (firstName != null) {
					error = true;
				}
				
				firstName = value;
				break;
			case "lastName":
				if (lastName != null) {
					error = true;
				}
				
				lastName = value;
				break;
			case "password":
				if (password != null) {
					error = true;
				}
				
				password = value;
				break;
			case "balance":
				if (balance != -1) {
					error = true;
				}
				
				balance = Long.parseLong(value);
				break;
			default:
				error = true;
			}
		}
		
		s.close();
		
		if (error || email == null || firstName == null || lastName == null || password == null || balance == -1) {
			throw new IllegalStateException();
		}
		
		return Data.createData(email, firstName, lastName, password, balance);
	}
	
}
