package com.rev.question14;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*Question 14: Write a program that demonstrates the switch case. 
 * 
 * Implement the following functionalities in the cases:
 * Case 1: Find the square root of a number using the Math class method. 
 * Case 2: Display today’s date.
 * Case 3: Split the following string and store it in a sting array. 
 * 	“I am learning Core Java”
*/
public class Switch {
	public static void main(String[] args) {
		switchLogic();
	}
	
	public static int switchLogic() {
		System.out.print("Displaying the use of a switch statement.\n "
				+ "\n1: Find the square root of a number using the Math class method."
				+ "\n2: Display today’s date."
				+ "\n3: Split the following string and store it in a sting array. \r    'I am learning Core Java'"
				+ "\nPlease enter a integer 1, 2 or 3: ");
		
		Scanner scan = new Scanner(System.in);
		int response = scan.nextInt();
		
		
		switch(response) {
			case 1:
				System.out.println("Enter an integer to find the square root of: ");
				Scanner keyboard = new Scanner(System.in);
				int num = keyboard.nextInt();
				double rslt = squareRoot(num);
				System.out.println("The resulting square root is: " + rslt);
				return 1;
			case 2:
				String date = todaysDate();
				System.out.println("Today's date is: " + date);
				return 1;
			case 3:
				System.out.println("Splitting the string 'I am learning Core Java' into a string array.");
				
				return 1;
			default:
				System.out.println("Response is not an integer {1, 2, 3}.");
				return 0;
		}
	}
	
	public static double squareRoot(int x) {
		double rslt = Math.sqrt(x);
		return rslt;
	}
	
	public static String todaysDate() {
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		return date;
	}
	
	public static String[] splitIntoArray(String str) {
		String[] arr = str.split(" ");
		return arr;
	}
}
