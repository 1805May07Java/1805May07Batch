package com.ex.RUN;
//package com.ex.BankingProject;
//
//import java.io.IOException;
//import java.util.Scanner;
//
//import com.ex.DAO.AccountDAO;
//import com.ex.DAO.AccountDAOimp;
//import com.ex.DAO.UserDAO;
//import com.ex.DAO.UserDAOimp;
//import com.ex.POJO.User;
//
//public class App {
//
//	public static void main( String[] args ) throws IOException {
//    	User loggedOn = null;
//    	UserDAO userDAO = new UserDAOimp();
//    	AccountDAO accountDAO = new AccountDAOimp();
//    	Scanner scanner = new Scanner(System.in);
//    	
//    	int option1;  //allows user to logout or exit application
//    	do {
//
//    		char response;
//    		System.out.println("Welcome!");
//    	
//    		do {
//    			System.out.println("Returning User? (y/n)");
//    			response = scanner.next().toLowerCase().charAt(0);
//    	
//    			switch (response) {
//    			case 'y':
//    				loggedOn = DAO.logOn(scanner);
//    				break;
//    			case 'n':
//    				loggedOn = DAO.createUser(scanner);
//    				break;
//    			default: 
//    				System.out.println("Sorry, input was not recognized");
//    			}
//
//    		} while (loggedOn == null);
//        
//    	
//    		do {
//    			loggedOn.account.displayAccountInfo();
//    			System.out.println("What would you like to do:"
//    					+ "\n1: Update Account"
//    					+ "\n2: Log Out"
//    					+ "\n0: Exit");
//    			option1 = scanner.nextInt();
//    			switch (option1) {
//    				case 1:
//    					System.out.println("What change do you want to make?:"
//    							+ "\n1: deposit"
//    							+ "\n2: withdraw"
//    							+ "\n0: back");
//    					int option2 = scanner.nextInt();
//    					int amount;
//    					switch (option2) {
//    						case 1:
//    							System.out.println("Amount?");
//    							amount = scanner.nextInt();
//    							loggedOn.account.setBalance(loggedOn.account.getBalance()+amount);
//    							DAO.updateAccount(loggedOn.account);
//    							break;
//    						case 2:
//    							System.out.println("Amount?");
//    							amount = scanner.nextInt();
//    							loggedOn.account.setBalance(loggedOn.account.getBalance()-amount);
//    							DAO.updateAccount(loggedOn.account);
//    							break;
//    						case 0:
//    							break;
//    						default : 
//    							break;
//    					}
//    					break;
//    				case 2:
//    					loggedOn = null;
//    					break;
//    				case 0:
//    					loggedOn = null;
//    					break;
//    				default :
//    					break;
//    			}
//    		} while (option1!=0 && option1!=2);	//return to login
//    	} while (option1!=0);					//exit application
//    	//do while not exit
//
//    	scanner.close();
//    }
//}
