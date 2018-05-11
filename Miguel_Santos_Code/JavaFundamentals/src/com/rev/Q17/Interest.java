package com.rev.Q17;

import java.util.Scanner;

public class Interest {
	
	private float principal;
	private float rate;
	private int years;
	
	public float calcInterest() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter principal amount: ");
		principal = scan.nextFloat();
		System.out.println("Enter interest rate(0-1): ");
		rate = scan.nextFloat();
		System.out.println("Enter # of years: ");
		years = scan.nextInt();
		
		scan.close();
		
		return principal*rate*years;
	}
	
	
}
