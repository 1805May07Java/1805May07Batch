package pojo;

public class User_BankAccount {
	User u;
	BankAccount b;
	
	public User_BankAccount(User u, BankAccount b) {
		super();
		this.u = u;
		this.b = b;
	}

	@Override
	public String toString() {
		return "User_BankAccount (ba,u) : (" + u +"," + b + ")"; 
	}
	
	
}
