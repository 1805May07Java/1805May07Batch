//package com.ex.RUN;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import com.ex.DAO.AccountDAO;
//import com.ex.DAO.AccountDAOimp;
//import com.ex.DAO.UserDAO;
//import com.ex.DAO.UserDAOimp;
//import com.ex.POJO.Account;
//import com.ex.POJO.User;
//
//public class testMain {
//	static UserDAO userDAO;
//	static AccountDAO accDAO;
//	
//	public static void main( String[] args ) throws IOException {
//		User loggedOn = null;
//    	userDAO = new UserDAOimp();
//    	accDAO = new AccountDAOimp();
//    	Scanner scanner = new Scanner(System.in);
//    	
//    	int option1;  //allows user to logout or exit application
//    	//do {
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
//    				loggedOn = logOn(scanner);
//    				break;
//    			case 'n':
//    				loggedOn = createUser(scanner);
//    				break;
//    			default: 
//    				System.out.println("Sorry, input was not recognized");
//    			}
//
//    		} while (loggedOn == null);
//    		System.out.println(loggedOn.getEmail());
//	}
//	
//	public static User logOn(Scanner scanner) {
//		String email;
//		String password;
//		
//		//check if username and password are correct
//		do {
//			System.out.println("Email:");
//			email = scanner.next();
//		
//			System.out.println("Password:");
//			password = scanner.next();
//		
//			if (!(userDAO.getByEmail(email).getEmail().equals(email))) {
//				System.out.println("Wrong username or password");
//			}
//		} while (!(userDAO.getByEmail(email).getEmail().equals(email)));
//		
//		return userDAO.getByEmail(email);
//	}
//	
//	public static User createUser(Scanner scanner) {
//		String firstName;
//		String lastName;
//		String email;
//		String password;
//		String passConfirm;
//		
//		//check if email is already used
//		do {
//			System.out.println("Email:");
//			email = scanner.next();
//			
//			if (userDAO.checkUserEmail(email)) {
//				System.out.println("Eamil is already being used, try another");
//				//TODO return user to log in, as likely already signed up
//			}
//		} while (userDAO.checkUserEmail(email));
//		
//		//set a new password and confirm input
//		do {
//			System.out.println("Password:");
//			password = scanner.next();
//			System.out.println("Confirm Password:");
//			passConfirm = scanner.next();
//			
//			if (!password.equals(passConfirm)) {
//				System.out.println("Passwords do not match, please try again");
//			}
//		} while (!password.equals(passConfirm));
//		
//		System.out.println("First name:");
//		firstName = scanner.next();
//		System.out.println("Last name:");
//		lastName = scanner.next();
//		
//		userDAO.addUser(firstName, lastName, email, password);
//		
//		return userDAO.getByEmail(email);
//	}
//}
//	
