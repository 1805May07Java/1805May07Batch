package com.rev.designpatterns.dao;

//import java.security.Provider.Service;
import java.util.Scanner;

//import javax.xml.crypto.dsig.SignedInfo;

//import com.rev.excersizes.InccorectInputException;

public class App {

	static StudentService service = new StudentService();
	
	public static void main(String[] args) {
	
		//get info from console to populate new student object and allow log in

		start();
		//	ioDAO dao = new ioDAO();
			
		//	dao.serializeRoster();
	}
	
	static void start(){
		System.out.println("Welcome to our student app!" 
						+ "\n" + "What would you like to do?" 
						+ "\n" + "1: Log in"
						+ "\n2: Sign up");
		
		Scanner scan = new Scanner(System.in);
		int op = 0;
		try {
			op = Integer.parseInt(scan.nextLine());
		}
		catch(NumberFormatException nfe) {
			//nfe.printStackTrace();
			System.out.println("Sorry not an option please try again");
			start();
		}
		
		switch(op) {
			case 1: login(); break;
			case 2: signUp(); break;
			default: System.out.println("Sorry that is not an option"); start(); break;
		}
		scan.close();
		
	}
	
	static void login() {
		Scanner in = new Scanner(System.in);
		System.out.println("Logging in...\n"
				+ "Enter your username:");
		String username = in.nextLine();
		if(!service.exists(username)) {
			System.out.println("you are not a user please try again");
			login();
		}
		else {
			Student stud = service.getByUsername(username);
			System.out.println("Enter your password");
			String password = in.nextLine();
			
			if(stud.getPassword().equals(password)) {
				doThings(stud);
			}
			else {
				System.out.println("Your password is incorrect. try again");
				login();
			}
		}
		in.close();
		
		
		
	}
	
	static void signUp() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Signing up...");
		System.out.println("enter a username");
		String username = scan.nextLine();
		String password;
		double gpa = 0;;
		if(!service.exists(username)) {
			
			
			System.out.println("Enter a password");
			password = scan.nextLine();
			
				System.out.println("enter a gpa");
			try {
			
				gpa = Double.parseDouble(scan.nextLine());
			}
			catch(NumberFormatException nfe) {
				//nfe.printStackTrace();
				System.out.println("Sorry not an option please try again");
				signUp();
			}
			
			service.addStudent(username, password, gpa);
			
		}
		else {
			System.out.println("Username Taken try again.");
			signUp();
		}
		
		scan.close();
	}
	
	static void doThings(Student s) {
		//change user info
		
	}
	
	static void logOut() {
		System.out.println("Thank you!");
		//serialize roster
		
	}
}
