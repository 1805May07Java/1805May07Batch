package question_17;

import java.util.Scanner;

public class CalculateInterest {
	public static void main(String[] args) {
		/*
		 * As the instructions said, We instantiate a Scanner class, then ask for 3 inputs
		 * The inputs are in order for the principal, rate, and then time.
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("Input the principal: ");
		double principal = scan.nextDouble();
		System.out.print("Input the rate: ");
		double rate = scan.nextDouble();
		System.out.print("Input the time: ");
		double time = scan.nextDouble();
		
		double interest = principal * rate * time;
		
		System.out.println("Interest: " + interest);
	}
}
