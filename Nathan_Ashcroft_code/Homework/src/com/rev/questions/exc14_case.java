package com.rev.questions;

import java.util.Date;

public class exc14_case {
	/*Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
		Case 1: Find the square root of a number using the Math class method. 
		Case 2: Display today’s date.
		Case 3: Split the following string and store it in a sting array. 
		“I am learning Core Java” */
	
	public void cas(int ca, int num) {
		switch(ca){
			case 1:
				System.out.println(Math.sqrt(num));
				break;
			case 2:
				Date d = new Date();
				System.out.println("Todays date is: " + d);
				break;
			case 3:
				String l = "I am learning Core Java";
				String [] p = new String [23];
				for (int i = 0; i < l.length(); i++) {
					p[i] = Character.toString(l.charAt(i));
				}
				System.out.print("the Char array is: ");
				for(int i = 0; i < p.length; i++) {
					System.out.print(p[i]);
				}
				break;
			default:
				System.out.println("not a correct case!");
				break;
		}
	}
}
