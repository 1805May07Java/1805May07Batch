package question10;

import java.util.Scanner;

public class FindSmallest {
	public static void main(String[] args) {
		
	
	Scanner scanner = new Scanner( System.in );
	System.out.println("Enter first number");
	int a = scanner.nextInt();
	System.out.println("Enter second number");
	int b = scanner.nextInt();
	scanner.close();
	
	int smaller = (a < b) ? a : b;
	
	System.out.println(smaller);
	}
}
