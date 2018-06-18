package com.banking.ui;

import java.util.concurrent.TimeUnit;

public class Application {

//	This is our banking application. This App allows for a user to initially Sign up or Log in
//	to their account. After logging into their account they can update the account balance. 
//	The usernames cannot be replicated, but the passwords may. The user information will be 
//	persistent in a text file.
	
	
//	Our Application class does not have much functionality but allows for later implementation
//	of a GUI.
	public static void main(String[] args) {
		
		//Welcome our client
		System.out.println("----Welcome To Bank of Mike----" +"\n"
						+  "--Thanks for banking with us!--" +"\n"
						+  "-------------------------------" +"\n\n");
		//This is to give our user some time to read our introduction
//				try {
//					TimeUnit.SECONDS.sleep(4);
//				} catch (InterruptedException e) {
//					
//					e.printStackTrace();
//				}
		//////////////////////////////////////////
				
		//Pass the process onto controller
		Controller c = new Controller();
		c.start();
	}
	
	
	
}
