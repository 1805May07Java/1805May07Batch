package com.ex.reverse;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		
		System.out.println("Please enter the String to be reverse");
		String original, reverse = "";
		Scanner sc = new Scanner(System.in);
		original = sc.nextLine();
		
		for (int i = original.length() - 1; i >= 0; i--) {
			reverse = reverse + original.charAt(i);
			
		}
		
		System.out.println("reverse of input string: " + reverse);
		
	}

}
