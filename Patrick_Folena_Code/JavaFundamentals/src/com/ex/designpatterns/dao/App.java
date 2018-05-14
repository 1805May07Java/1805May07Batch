package com.ex.designpatterns.dao;

import java.util.Scanner;

public class App {
	
	static StudentService service = new StudentService();
	
	//main class to run student app
	public static void main(String[] args) {
		
		//get info from console to create new student object. and aloow them to log in.
		
		start();
	}

    static void start() {
		
		System.out.println("Welcome to our student app! \n"
				+ "What would you like to do? (Type Option Number)\n"
				+ "1 : Log in \n"
				+ "2 : Sign up");
		
		Scanner scan = new Scanner(System.in);
		int op = 0;
		try {
			op = Integer.parseInt(scan.nextLine());
		}
		catch(NumberFormatException e)
		{
			//e.printStackTrace();
			System.out.println("Sorry, that's not an option. Please try again");
			start();
		}
		
		switch(op) {
		case 1: logIn();
			break;
		case 2: signUp();
			break;
		default: System.out.println("Sorry, that's not an option. Please try again");
		start();
		}
		scan.close();
	}
    
    static void logIn() {
    	Scanner in = new Scanner(System.in);
    	System.out.println("Logging in.... \n"
    			+ "Enter your username:");
    	String username = in.nextLine();
    	if(username.equals("Exit"))
    	{
    		start();
    		return;
    	}
    	if(!service.exists(username)) {
    		System.out.println("You aren't a user. Please try again");
    		logIn();
    	}
    	else {
    		Student stud = service.getByUsername(username);
    		System.out.println("Enter your password");
    		String password = in.nextLine();
    		if(stud.getPassword().equals(password)) {
    			doThings(stud);
    		}
    		else {
    			System.out.println("Username and/or Password is not recognized.");
    			logIn();
    			return;
    		}
    	}
    	//Check to see if username exists in our persistence
    	in.close();
    }
    
    static void doThings(Student maboy) {
    	System.out.println("Welcome " + maboy.getUsername() + "!");
    	System.out.println("Your GPA is " + maboy.getGpa() + "\n");
    	start();
    }
    
    static void signUp() {
    	Scanner in = new Scanner(System.in);
    	System.out.println("Signing up.... \n"
    			+ "Enter a username:");
    	String username = in.nextLine();
    	if(service.exists(username)) {
    		System.out.println("Username is already taken. Please try again");
    		signUp();
    	}
    	else {
    		System.out.println("Enter a password");
    		String password = in.nextLine();
    		System.out.println("Enter your GPA");
    		String gpa = in.nextLine();
    		double grade = 0;
    		
    		try {
    			grade = Double.parseDouble(gpa);
    		}
    		catch(NumberFormatException e)
    		{
    			System.out.println("Could not parse GPA");
    		}
    		service.addNewStudent(username, password, grade);
    		System.out.println("User creation successful!");
    		start();
    	}
    	//username; must be UNIQUE
    	//password -
    	//ask gpa
    	//id
    }
}