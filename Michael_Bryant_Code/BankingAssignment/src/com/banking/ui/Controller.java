package com.banking.ui;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Controller {
	
//	Our controller class will over see all functionality to the client. From here
//	we can direct the client to Services and information returned will be sent to the 
//	IODAO to be stored. The controller will allow us to load information before directing.
	
	private AccountServices user;
	private Scanner in;
	private ArrayList<Account> service = new ArrayList<Account>();
	

	
	public void start() {
		//Start an instance of user and load our ArrayList
		user = new AccountServices();
		
		
		
		//Prompt user to see begin log in or sign up
		System.out.println(  "Let's Begin by creating or accessing your account."   +"\n"
							+"Please give the number input for the desired option:" +"\n"
							+"----------------------------------------------------" +"\n"
							+"1: Log In (Must have existing account)" +"\n"
							+"2: Sign Up" +"\n"
							+"----------------------------------------------------" );
		
		//Take the user input to see what should be done
		in = new Scanner(System.in);
		user = new AccountServices();
		int input = 0;
		//Checks if input is an Integer
		try {
			
			input = Integer.parseInt(in.nextLine());
			
			}catch(NumberFormatException nfe) {
				System.out.println("!!INVALID INPUT!! Try Again! ");
				start();
			}
		
		//Checks if Integer is a valid option if not run through again
		
		switch(input) {
		case 1: user.logIn(); break; //Log In
		case 2: user.signUp(); break; //Sign Up
		default: System.out.println("Sorry, that's not an option. Please try again");
		start();
		}
		

	}
}
