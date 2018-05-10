package com.rev.question6;

import java.util.Scanner;

//Quesiton 6: Write a program to determine if an integer is even without using the modulus operator (%)
public class Even {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter a number to determine if it's even: ");
		int test = keyboard.nextInt();
		
		boolean answer = even(test);
		
		if(answer) {
			System.out.print("The number, " + test + " is even.");
		}else {
			System.out.print("The number, " + test + " is odd.");
		}
		
		
		
	}
	
	public static boolean even(int x) {
		boolean even = true;
		
		if((x&1) == 1) {
			even = false;
		}
		
		if(even) {
			return true;
		}else {
			return false;
		}
	}
}
