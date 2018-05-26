package com.ex.designpatterns.dao;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	static StudentService service = new StudentService();

	//main class to run student app
	public static void main(String[] args) {

		//get info from console to create new student object. and allow them to log in

	//start();

		IODAO dao = new IODAO();
		
		ArrayList<Student> students = dao.deserialize();

		for(Student s : students) {
			System.out.println(s);
		}
		
	//dao.serializeRoster();

	}

	static void start(){
		System.out.println("Welcome to our student app!"
				+ "\nWhat would you like to do?"
				+ "\n1: Log In"
				+ "\n2: Sign up");

		Scanner scan = new Scanner(System.in);
		int op = 0;
		try {
			op = Integer.parseInt(scan.nextLine());
		}
		catch(NumberFormatException nfe) {
			//nfe.printStackTrace();
			System.out.println("Sorry, that's not an option. Please try again");
			start();
		}

		switch(op) {
		case 1: logIn(); break;
		case 2: signUp(); break;
		default: System.out.println("Sorry, that's not an option. Please try again");
		start();
		}
		scan.close();
	}

	static void logIn() {
		Scanner in = new Scanner(System.in);
		System.out.println("Logging in....\n"
				+ "Enter your username:");
		String username = in.nextLine();
		if(!service.exists(username)) {
			System.out.println("You arent a user. please try again");
			logIn(); 
		}
		else {
			Student stud = service.getByUsername(username);
			System.out.println(stud.toString());
			System.out.println("Enter your password");
			String password = in.nextLine();
			// test if password is valid
			if(stud.getPassword().equals(password)) {
				doThings(stud);
			}
			else {
				System.out.println("Sorry, your password was incorrect. try again");
				logIn();
			}
		}

	}

	static void signUp() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your username");
		String username = scan.nextLine();
		if(service.exists(username)) {
			System.out.println("sorry, that username is taken,");
			signUp();
		}
		else {
			// make sure username doesnt exist
			System.out.println("Thanks, " + username + ". What's your password?");
			String password =  scan.nextLine();
			System.out.println("And GPA?");
			String gp = scan.nextLine();
			double gpa;
			try{
				gpa= Double.parseDouble(gp); // do input validation
			}
			catch(NumberFormatException nfe) {
				nfe.printStackTrace();
				System.out.println("that wasn't a valid GPA, "
						+ "lets just give you a 2.0 for being difficult");
				gpa = 2.0;
			}
			Student student = service.addStudent(username, password, gpa);
			doThings(student);
		}
		//login or dothings

	}

	static void doThings(Student s) {
		// change user info or whatever
		System.out.println("Youre in! lets do stuff");
		
	}
	
	static void logOut() {
		System.out.println("Thank you!");
		//serialize student roster
	}
}
