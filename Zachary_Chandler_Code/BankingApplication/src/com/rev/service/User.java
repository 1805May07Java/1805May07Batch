package com.rev.service;

import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

import com.rev.dao.UserDAO;

public final class User {
	
	private static final UserDAO DAO = UserDAO.getInstance();
	
	private final Data data;

	private User(Data data) {
		this.data = data;
	}

	public String getID() {
		return data.id;
	}
	
	public String getEmail() {
		return data.email;
	}

	public String getFirstName() {
		return data.firstName;
	}

	public String getLastName() {
		return data.lastName;
	}

	public long getBalance() {
		return data.balance;
	}
	
	public String getPassword() {
		return data.password;
	}
	
	public long deposit(long amount) {
		
		if (amount < 0) {
			throw new IllegalArgumentException();
		}
		
		data.balance += amount;
		DAO.write(this);
		return data.balance;
	}
	
	public long withdraw(long amount) {
		
		if (amount < 0 || amount > data.balance) {
			throw new IllegalArgumentException();
		}
		
		data.balance -= amount;
		DAO.write(this);
		return data.balance;
	}
	
	public static User getUser(String email, String password) {
		
		String id = hash(email.toLowerCase());
		password = hash(email.toLowerCase() + password);
		Data data;
		
		try {
			data = DAO.getData(id);
			
			if (!data.password.equals(password)) {
				return null;
			}
		} catch (FileNotFoundException e) {
			return null;
		}
		
		return new User(data);
	}
	
	public static User createUser(String email, String firstName, String lastName, String p1) {
		Data data = new Data(email, firstName, lastName, hash(email.toLowerCase() + p1), 0);
		
		if (DAO.exists(data.id)) {
			throw new IllegalArgumentException();
		}
		
		User u = new User(data);
		
		DAO.write(u);
		
		return u;
	}
	
	public static boolean exists(String email) {
		return DAO.exists(hash(email.toLowerCase()));
	}

	private static String hash(String n) {
		MessageDigest md;
		
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
		
		byte[] digest = md.digest(n.getBytes());
		
		StringBuilder result = new StringBuilder();
		
		for (byte b : digest) {
			result.append(String.format("%02x", b));
		}
		
		return result.toString();
	}
	
	private static String nameFormat(String value) {
		StringBuilder result = new StringBuilder();
		
		result.append(value.toLowerCase());
		result.setCharAt(0, Character.toUpperCase(value.charAt(0)));
		
		return result.toString();
	}
	
	public static class Data {
		
		private static Map<String, Data> datas = new TreeMap<String, Data>();
		
		public final String id;
		public final String email;
		public final String firstName;
		public final String lastName;
		public final String password;
		public long balance;
		
		private Data(String email, String firstName, String lastName, String password, long balance) {
			this.id = getID(email);
			this.email = email;
			this.firstName = nameFormat(firstName);
			this.lastName = nameFormat(lastName);
			this.password = password;
			this.balance = balance;
		}
		
		public static String getID(String email) {
			return User.hash(email.toLowerCase());
		}
		
		public static Data getData(String id) {
			return datas.get(id);
		}
		
		public static synchronized Data createData(String email, String firstName, String lastName, String password, long balance) {
			Data d = getData(getID(email));
			
			if (d == null) {
				d = new Data(email, firstName, lastName, password, balance);
				datas.put(d.id, d);
			} else if (d.firstName != firstName || 
					   d.lastName != lastName || 
					   d.password != password || 
					   d.balance != balance) {
				
				throw new IllegalArgumentException();
			}
			
			return d;
		}
	}
}
