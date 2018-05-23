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
    			int option2;
    			int option3;
    			if (loggedOn.getIsAdmin()) {
    				System.out.println("What would you like to do:"
        					+ "\n1: Manage Accounts"
        					+ "\n2: Manage Users"
        					+ "\n3: Log Out"
        					+ "\n4: Exit");
        			option1 = scanner.nextInt();
        			switch (option1) {
    					case 1:
    						Account toUpdate = null;
        					System.out.println("Which account would you like to update?");
    						int accNo = scanner.nextInt();
        					do {
        						if (accDAO.checkAccID(accNo)) {
    		    					for (Account a : userDAO.getUserAccounts(loggedOn.getUserID())) {
    		    						if (a.getAccountNumber() == accNo) {
    		    							toUpdate = a;
    		    						}
    		    					}
        						} else {
        							System.out.println("That account is not in the system.");
        							System.out.println("Which account would you like to update?");
        						}
        					} while (!accDAO.checkAccID(accNo));
        					System.out.println("What change do you want to make?:"
        							+ "\n1: set balance"
        							+ "\n2: add user"
        							+ "\n3: remove user"
        							+ "\n3: delete account"
        							+ "\n4: back");
        					option2 = scanner.nextInt();
        					double amount;
        					toUpdate = accDAO.getById(accNo);
        					switch (option2) {
        						case 1:
        							System.out.println("Amount?");
        							amount = scanner.nextDouble();
        							toUpdate.setBalance(amount);
        							accDAO.updateAccountBalance(toUpdate.getAccountNumber(), toUpdate.getBalance());
        							break;
        						case 2:
        							int userId;
        							do {
        								System.out.println("Which user would you like to add?(0 to exit):");
        								userId = scanner.nextInt();
        							
        								if (!(userDAO.checkUserID(userId))) {
        									System.out.println("That userid is not in the system");
        								} else if (userId ==0) {break;
        								} else if (userDAO.checkUserID(userId)) {
        									accDAO.addAccountOwner(accNo, userId);
        									System.out.println("Account owner added");
        								}
        							} while (!(userDAO.checkUserID(userId)));
        							break;
        						case 3:
        							do {
        								System.out.println("Which user would you like to remove?(0 to exit):");
        								userId = scanner.nextInt();
        							
        								if (!(userDAO.getUserAccounts(userId).contains(accDAO.getById(accNo)))) {
        									System.out.println("That userid is not in the system");
        								} else if (userId ==0) {break;
        								} else if (!(userDAO.getUserAccounts(userId).contains(accDAO.getById(accNo)))) {
        									accDAO.removeAccountOwner(accNo, userId);
        									System.out.println("Account owner removed");
        								}
        							} while (!(userDAO.getUserAccounts(userId).contains(accDAO.getById(accNo))));
        							break;
        						case 4:
        							System.out.println("Are you sure? (y/n)");
        							char confirm = scanner.next().toLowerCase().charAt(0);
        							do {
    	    							switch (confirm) {
    		    		    			case 'y':
    		    		    				accDAO.removeAccount(toUpdate.getAccountNumber());
    		    		    				loggedOn.removeAccount(toUpdate);
    		    		    				break;
    		    		    			case 'n':
    		    		    				break;
    		    		    			default: 
    		    		    				System.out.println("Sorry, input was not recognized");
    		    		    			}
    	    							if(confirm == 'n') {break;}
        							} while(confirm!='y' && confirm != 'n');
        							break;
        						default : 
        							break;
        					}
        					
        					break;
    					case 2:
        					System.out.println("Which user would you like to update?");
    						int userNo = scanner.nextInt();
        					do {
        						if (userDAO.checkUserID(userNo)) {
        						} else {
        							System.out.println("That account is not in the system.");
        							System.out.println("Which account would you like to update?");
        						}
        					} while (!userDAO.checkUserID(userNo));
        					System.out.println("What change do you want to make?:"
        							+ "\n1: make admin"
        							+ "\n2: delete user"
        							+ "\n4: back");
        					option2 = scanner.nextInt();

        					switch (option2) {
        						case 1:
        							userDAO.makeAdmin(userNo);
        							break;
        						case 2:
        							System.out.println("Are you sure? (y/n)");
        							char confirm = scanner.next().toLowerCase().charAt(0);
        							do {
    	    							switch (response) {
    		    		    			case 'y':
    		    		    				userDAO.removeUser(userNo);
    		    		    				break;
    		    		    			case 'n':
    		    		    				break;
    		    		    			default: 
    		    		    				System.out.println("Sorry, input was not recognized");
    		    		    			}
        							} while(confirm!='y' && confirm != 'n');
        							break;
        					}
        			} break; //if admin, and done with activity				
    			} else {
    			
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
						int accNo;
    					do {
    						accNo = scanner.nextInt();
    						if (loggedOn.getAccountNumbers().contains(accNo)) {
		    					for (Account a : userDAO.getUserAccounts(loggedOn.getUserID())) {
		    						if (a.getAccountNumber() == accNo) {
		    							toUpdate = a;
		    						}
		    					}
    						} else {
    							System.out.println("That is not your account.");
    							System.out.println("Which account would you like to update?");
    						}
    					} while (!loggedOn.getAccountNumbers().contains(accNo));
    					// add remove account
    					System.out.println("What change do you want to make?:"
    							+ "\n1: deposit"
    							+ "\n2: withdraw"
    							+ "\n3: delete account"
    							+ "\n4: back");
    					option3 = scanner.nextInt();
    					double amount;
    					switch (option3) {
    						case 1:
    							System.out.println("Amount?");
    							amount = scanner.nextDouble();
    							toUpdate.deposit(amount);
    							accDAO.updateAccountBalance(toUpdate.getAccountNumber(), toUpdate.getBalance());
    							break;
    						case 2:
    							System.out.println("Amount?");
    							amount = scanner.nextDouble();
    							toUpdate.withdraw(amount);
    							accDAO.updateAccountBalance(toUpdate.getAccountNumber(), toUpdate.getBalance());
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
    			};
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
		
			if (!(userDAO.checkUserEmail(email)) && !userDAO.checkUserPassword(userDAO.getByEmail(email).getUserID(),password)) {
				System.out.println("Wrong username or password");
			}
		} while (!(userDAO.checkUserEmail(email)));
		
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
