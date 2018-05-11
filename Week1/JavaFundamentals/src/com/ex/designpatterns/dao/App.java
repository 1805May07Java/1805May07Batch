package com.ex.designpatterns.dao;

import java.util.Scanner;

public class App {

	//main class to run student app
	public static void main(String[] args) {
	
		//get info from console to create new student object. and allow them to log in
		
		start();
		
	}
	
	static void start(){
		System.out.println("Welcome"
				+ "\nWhat would you like to do"
				+ "\n1: log in"
				+ "\n2: sign up");
		
		Scanner scanner = new Scanner(System.in);
		int op = 0;
		try {
			op = Integer.parseInt(scanner.nextLine());
		}
		catch (NumberFormatException nfe) {
			//nfe.printStackTrace();
			System.out.println("Sorry that is not an option");
			start();
		}
		
		switch (op) {
		case 1: login(); break;
		case 2: signup(); break;
		default:
			System.out.println("Sorry that is not an option");
			start();	
		}
		scan.close();
	}
	
	static void 

}
