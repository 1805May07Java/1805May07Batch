package com.rev.questions;

import java.util.Scanner;

public class InterestCalculator {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Principal: ");
		double p = s.nextDouble();
		
		System.out.println("Rate: ");
		double r = s.nextDouble();
		
		System.out.println("Time: ");
		double t = s.nextDouble();
		
		System.out.println("Simple interest is roughly: " + p * r * t);
		
		s.close();
	}
}
