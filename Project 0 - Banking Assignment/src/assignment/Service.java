package assignment;

import java.util.ArrayList;

public class Service {
	static ArrayList<User> users;
	
	static {
		users = new ArrayList<>();
		users.add(new User(0, "alexmoon", "Alex", "Moon", "password", 1.50));
		users.add(new User(1, "obams", "Barack", "Obama", "password", 1000));
		users.add(new User(2, "realDonald", "Donald", "Trump", "password", 1_000_000));
		users.add(new User(4, "ww", "Willy", "Wonka", "password", 0));
		users.add(new User(5, "leking", "LeBron", "James", "password", 23));
		users.add(new User(8, "billgates", "Bill", "Gates", "password", 1_000_000_000));
		users.add(new User(11, "euler", "Leonard", "Euler", "password", 2.71));
	}
	
	/**
	 * The ArrayList of Users is a static list, so this function is just to return it
	 * 
	 * @return Returns 'users', the static list of all users in the app.
	 */
	ArrayList<User> getAllLocal() {
		return users;
	}
	
	/**
	 * This function adds a user to the list, then sync's it with the users.txt file
	 * 
	 * @param u The User object we are going to add to the list
	 * @return Returns false if the User is already in the list. Returns true if we successfully add the user to the list.
	 */
	static boolean addUser(User u) {
		if(findUser(u.getUsername()) != null)
			return false;
		
		int i=0;
		// find the index of where we are going to insert the user into the list.
		for(; i<users.size(); i++) {
			int curr = users.get(i).getId();
			if(i != curr) {
				break;
			}
		}
		u.setId(i);
		users.add(i, u);
		DAO.syncUsers(users);
		return true;
	}
	
	/**
	 * 
	 * This function deletes a user from the list, then sync's it with the users.txt file
	 * 
	 * @param username The User's username, we fill find the User based off this information
	 * @return Returns true if the User is removed, and false if we dont remove the User (usually because the User isn't in the list).
	 */
	boolean deleteUser(String username) {
		User u = findUser(username);		
		if(users.remove(u)) {
			DAO.syncUsers(users);
			return true;
		}
		return false;
		
	}
	
	/**
	 * 
	 * This function deposits money into a User's account balance, then sync's it to the users.txt file
	 * If the User doesn't exist or if amt <= 0, the function does an early return (basically doing nothing)
	 * 
	 * @param username The User's username so we can find the User in the list
	 * @param amt The amount that the User wants to deposit.
	 */
	static void deposit(String username, double amt) {
		User u = findUser(username);
		if(u == null || amt <= 0) return;
		u.setBalance(u.getBalance() + amt);
		DAO.syncUsers(users);
	}

	/**
	 * 
	 * This function withdraws money from the User's account balance, then sync's it to the users.txt file
	 * 
	 * @param username The User's username so we can find the User in the list
	 * @param amt The amount the User wants to withdraw
	 * @return Returns true if the user successfully withdraws money, and returns false if the user tries to withdraw too much money.
	 */
	static boolean withdraw(String username, double amt) {
		User u = findUser(username);
		if(u == null || u.getBalance() < amt) {
			return false;
		}
		else {
			u.setBalance(u.getBalance() - amt);
			DAO.syncUsers(users);
			return true;
		}
	}
	
	/**
	 * 
	 * Given a username, this function will find the User.
	 * 
	 * @param username The User's username so we can find the User in the list
	 * @return The User object that corresponds to the username. Returns null if the User is not in the list.
	 */
	static User findUser(String username) {
		for(User u : users) {
			if(u.getUsername().equals(username)) {
				return u;
			}
		}
		return null;
	}
}
