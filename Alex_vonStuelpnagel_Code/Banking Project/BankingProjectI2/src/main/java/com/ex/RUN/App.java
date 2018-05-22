package com.ex.RUN;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

import com.ex.DAO.AccountDAO;
import com.ex.DAO.AccountDAOimp;
import com.ex.DAO.UserDAO;
import com.ex.DAO.UserDAOimp;
import com.ex.POJO.Account;
import com.ex.POJO.User;

public class App {
	static UserDAO userDAO;
	static AccountDAO accDAO;

	public static void main( String[] args ) throws IOException {
    	User loggedOn = null;
    	userDAO = new UserDAOimp();
    	accDAO = new AccountDAOimp();
    	Scanner scanner = new Scanner(System.in);
    	
    	int option1;  //allows user to logout or exit application
    	do {

    		char response;
    		System.out.println("Welcome!");
    	
    		do {
    			System.out.println("Returning User? (y/n)");
    			response = scanner.next().toLowerCase().charAt(0);
    	
    			switch (response) {
    			case 'y':
    				loggedOn = logOn(scanner);
    				break;
    			case 'n':
    				loggedOn = createUser(scanner);
    				break;
    			default: 
    				System.out.println("Sorry, input was not recognized");
    			}

    		} while (loggedOn == null);
        
    	
    		//check if admin, disply admin options
    		do {
    			for (Account a :  userDAO.getUserAccounts(loggedOn.getUserID())) {
    				a.displayAccountInfo();
    			}
    			//addaccount remove account
    			System.out.println("What would you like to do:"
    					+ "\n1: Manage Accounts"
    					+ "\n2: Add Account"
    					+ "\n3: Log Out"
    					+ "\n4: Exit");
    			option1 = scanner.nextInt();
    			switch (option1) {
    				case 1:
    					Account toUpdate = null;
    					System.out.println("Which account would you like to update?");
    					int accNo = scanner.nextInt();
    					while (toUpdate == null) {
	    					for (Account a : userDAO.getUserAccounts(loggedOn.getUserID())) {
	    						if (a.getAccountNumber() == accNo) {
	    							toUpdate = a;
	    						}
	    					}
    					}
    					// add remove account
    					System.out.println("What change do you want to make?:"
    							+ "\n1: deposit"
    							+ "\n2: withdraw"
    							+ "\n3: delete account"
    							+ "\n4: back");
    					int option3 = scanner.nextInt();
    					double amount;
    					switch (option3) {
    						case 1:
    							System.out.println("Amount?");
    							amount = scanner.nextDouble();
    							toUpdate.setBalance(toUpdate.getBalance()+amount);
    							accDAO.updateAccountBalance(toUpdate.getAccountNumber(), toUpdate.getBalance()+amount);
    							break;
    						case 2:
    							System.out.println("Amount?");
    							amount = scanner.nextDouble();
    							toUpdate.setBalance(toUpdate.getBalance()-amount);
    							accDAO.updateAccountBalance(toUpdate.getAccountNumber(), toUpdate.getBalance()+amount);
    							break;
    						case 3:
    							System.out.println("Are you sure? (y/n)");
    							char confirm = scanner.next().toLowerCase().charAt(0);
    							do {
	    							switch (response) {
		    		    			case 'y':
		    		    				accDAO.removeAccount(toUpdate.getAccountNumber());
		    		    				loggedOn.removeAccount(toUpdate);
		    		    				break;
		    		    			case 'n':
		    		    				break;
		    		    			default: 
		    		    				System.out.println("Sorry, input was not recognized");
		    		    			}
    							} while(confirm!='y' && confirm != 'n');
    							break;
    						case 4:
    							break;
    						default : 
    							break;
    					}
    					
    					break;
    				case 2:
    					int accType;
    					do {
	    					System.out.println("What type of account would you like to create?:"
	    							+ "\n0: Credit"
	    							+ "\n1: Savings"
	    							+ "\n2: Checking");
	    					accType = scanner.nextInt();
	    					if (accType != 0 && accType != 1 && accType != 2) {
	    						System.out.println("Sorry, input was not recognized");
	    					}
    					} while (accType != 0 && accType != 1 && accType != 2);
    					accDAO.addAccount(loggedOn.getUserID(), accType);
    					loggedOn.addAccount(userDAO.getUserAccounts(loggedOn.getUserID()).get(userDAO.getUserAccounts(loggedOn.getUserID()).size()-1) );
    					break;
    				case 3:
    					loggedOn = null;
    					break;
    				case 4:
    					loggedOn = null;
    					break;
    				default :
    					System.out.println("Sorry, input was not recognized");
    					break;
    			}
    		} while (option1!=4 && option1!=3);	//return to login
    	} while (option1!=4);					//exit application
    	//do while not exit

    	scanner.close();
    }
	
	
	//service methods
	public static User logOn(Scanner scanner) {
		String email;
		String password;
		
		//check if username and password are correct
		do {
			System.out.println("Email:");
			email = scanner.next();
		
			System.out.println("Password:");
			password = scanner.next();
		
			if (!(userDAO.getByEmail(email).getEmail().equals(email))) {
				System.out.println("Wrong username or password");
			}
		} while (!(userDAO.getByEmail(email).getEmail().equals(email)));
		
		return userDAO.getByEmail(email);
	}
	
	public static User createUser(Scanner scanner) {
		String firstName;
		String lastName;
		String email;
		String password;
		String passConfirm;
		
		//check if email is already used
		do {
			System.out.println("Email:");
			email = scanner.next();
			
			if (userDAO.checkUserEmail(email)) {
				System.out.println("Eamil is already being used, try another");
				//TODO return user to log in, as likely already signed up
			}
		} while (userDAO.checkUserEmail(email));
		
		//set a new password and confirm input
		do {
			System.out.println("Password:");
			password = scanner.next();
			System.out.println("Confirm Password:");
			passConfirm = scanner.next();
			
			if (!password.equals(passConfirm)) {
				System.out.println("Passwords do not match, please try again");
			}
		} while (!password.equals(passConfirm));
		
		System.out.println("First name:");
		firstName = scanner.next();
		System.out.println("Last name:");
		lastName = scanner.next();
		
		userDAO.addUser(firstName, lastName, email, password);
		
		return userDAO.getByEmail(email);
	}
}
