package com.ex.bank;

import java.util.ArrayList;

public class BankServices {

	static ArrayList<User> users = new ArrayList<User>();
	static Dao dao = new Dao();
	static {
		users = dao.getData();
	}
	public void addStudent(String fn, String ln, String un, String pw) {
		users.add(new User(fn, ln, un, pw));
	}
	public boolean validUsername(String un) {
		for (User u: users) {
			if (u.getUsername().equalsIgnoreCase(un)) 
				return true;
		}
		return false;
	}
	public boolean validUnPw(String un, String pw) {
		for (User u: users) {
			if(u.getUsername().equalsIgnoreCase(un) && u.getPassword().equals(pw))
				return true;
		}
		return false;
	}
	public User findByUsername(String un) {
		for (User u: users) {
			if(u.getUsername().equalsIgnoreCase(un))
				return u;
		}
		return null;
	}
	
	public int findIndexByUsername(String un) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equalsIgnoreCase(un))
				return i;
		}
		return 0;
	}
	
	public void close() {
		dao.writeData(users);
		//System.out.println("number of users: " + users.size());
		System.exit(0);
		
	}
	public void withdraw(User u, double amt) {
		u.setBalance(u.getBalance() - amt);
		//System.out.println("Your new balance is: $" + String.format("%.2f", u.getBalance()));
		users.remove(findIndexByUsername(u.getUsername()));
		users.add(u);
	}
	public void deposit(User u, double amt) {
		u.setBalance(u.getBalance() + amt);
		//System.out.println("Your new balance is: $" + String.format("%.2f", u.getBalance()));
		users.remove(findIndexByUsername(u.getUsername()));
		users.add(u);
	}
}
