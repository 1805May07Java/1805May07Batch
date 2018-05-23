package com.Banking.main;

import com.Banking.util.Controller;

public class App 
{
//	This is our banking application. This App allows for a user to initially Sign up or Log in
//	to their account. After logging into their account they can update the account balance. 
//	The usernames cannot be replicated, but the passwords may. The user information will be 
//	persistent in a text file.

	
//	Our Application class does not have much functionality but allows for later implementation
//	of a GUI.
	public static void main(String[] args) {
		
		//Welcome our client
		System.out.println("----Welcome To Generic Credit Union----" +"\n"
						+  "------Thanks for banking with us!------" +"\n"
						+  "---------------------------------------" +"\n\n");
				
		//Pass the process onto controller
		Controller c = new Controller();
		c.start();
	}
}
