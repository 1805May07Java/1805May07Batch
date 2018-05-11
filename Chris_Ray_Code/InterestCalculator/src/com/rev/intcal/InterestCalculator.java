package com.rev.intcal;

import java.util.Scanner;

public class InterestCalculator {

	public static void main(String[] args) {
		double principle;
		double rate;
		double time;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter principle: ");
		principle = in.nextInt();
		System.out.println("Enter rate: ");
		rate = in.nextInt();
		System.out.println("Enter time: ");
		time = in.nextInt();
		
		calculateInterest(principle, rate, time);
		
		in.close();

	}
	
	public static double calculateInterest(double principle, double rate, double time) {
		return principle * rate * time;
	}

}
