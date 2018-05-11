package com.rev.interest;

import java.util.Scanner;

public class Interest {
	
	public static void main(String []args) {
		//Try with resources to prevent memory leak
		try(Scanner sca = new Scanner(System.in)){
		
		//Accept user input for each value and then multiply.
		System.out.println("Please enter the principal ammount");
		int principal=sca.nextInt();
		System.out.println("Please enter the rate");
		int rate=sca.nextInt();
		System.out.println("Please enter the time");
		int time=sca.nextInt();
		System.out.println("Your interest is " + principal*rate*time);
		}
	
		}
	}

