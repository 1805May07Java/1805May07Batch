package assignment;

import java.text.DecimalFormat;

public class User {
	private int id;
	private String username;
	private String firstname;
	private String lastname;
	private String password;
	private double balance;
	
	public User() {
		super();
	}

	public User(int id, String username, String firstname, String lastname, String password, double balance) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.balance = balance;
	}
	
	public User(String username, String firstname, String lastname, String password, double balance) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.balance = balance;
	}
	
	public User(String[] list) {
		super();
		if(list.length == 6) {
			this.id = Integer.parseInt(list[0]);
			this.username = list[1];
			this.firstname = list[2];
			this.lastname = list[3];
			this.password = list[4];
			this.balance = Double.parseDouble(list[5]);
		}
		
	}
	
	@Override
	public String toString() {
		DecimalFormat money = new DecimalFormat("0.00");
		return id + ":" 
				+ username + ":" 
				+ firstname + ":" 
				+ lastname + ":" 
				+ password + ":" 
				+ money.format(balance);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
