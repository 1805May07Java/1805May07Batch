package com.rev.week1;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import another.pckg.NonDescriptClass;

public class CoreJavaHW {
	public static void main(String args[]) {
		
		//Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0. 
		int intQ2 = 25;
		System.out.println("The first 25 fibonacci numbers: ");
		MyMath.getFibonacci(intQ2);
		
		/* Q3. Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the 
		 * StringBuilder APIs.
		 */
		String stringQ3 = "abcdefg";
		System.out.println("The original string is: " + stringQ3);
		String reversed = MyString.reverseString(stringQ3);
		System.out.println("The reversed string is: " + reversed);
		
		//Q4. Write a program to compute N factorial.
		int intQ4 = 11;
		System.out.println("The factorial of " + intQ4 + " is " + MyMath.factorial(intQ4));
		
		/* Q5. Write a substring method that accepts a string str and an integer idx and returns the substring contained
		 *  between 0 and idx-1 inclusive.  Do NOT use any of the existing substring methods in the String, 
		 *  StringBuilder, or StringBuffer APIs.
		 */
		String stringQ5 = "This message will be altered.";
		System.out.println("Using the String substring method: " + stringQ5.substring(0, 10));
		System.out.println("Using my substring method: " + MyString.substring(stringQ5, 10));
		
		/* Q6. Write a program to determine if an integer is even without using the modulus operator (%)s */
		int intQ6A = 134;
		int intQ6B = -107;
		System.out.println("Is the number " + intQ6A + " even? " + MyMath.isEven(intQ6A));
		System.out.println("Is the number " + intQ6B + " even? " + MyMath.isEven(intQ6B));
		
		/* Q7. Sort two employees based on their name, department, and age using the Comparator interface. */
		Employee e1 = new Employee("David", "Java EE", 22);
		Employee e2 = new Employee("Jane", "System Adminstrator", 25);
		Employee e3 = new Employee("David", "Spring Developer", 20);
		Employee e4 = new Employee("Alison", "Java EE", 22);
		Employee e5 = new Employee("Richard", "Angular", 30);
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		Collections.sort(list, new EmployeeComparator());
		System.out.println(list.toString());
	
		/* Q8. Write a program that stores the following strings in an ArrayList and saves all the palindromes in 
		 * another ArrayList. “karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”,  “refer”, 
		 * “billy”, “did”
		 */
		
		ArrayList<String> listQ8 = new ArrayList<String>(Arrays.asList("karan", "madam", "tom", "civic", "radar", 
				"sexes", "jimmy", "kayak", "john", "refer", "billy", "did"));
		ArrayList<String> palindromes = new ArrayList<String>();
		for (String s: listQ8) {
			if (MyString.isPalindrome(s)) {
				palindromes.add(s);
			}
		}
		Iterator<String> it = palindromes.iterator();
		System.out.print("The palindromes are: ");
		while(it.hasNext()) {
			String str = (String) it.next();
			System.out.print(str + ", ");
		}
		System.out.println();
		
		/* Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the 
		 * console.
		 */
		 System.out.println("Creating ArrayList of 1...100");
		 ArrayList<Integer> listQ9 = new ArrayList<Integer>();
		 for (int i=1; i<=100; i++) {
			 listQ9.add(i);
		 }
		 System.out.println("Now filtering out composite numbers.\nPrime values: ");
		 for (int i : listQ9) {
			 if (MyMath.isPrime(i)) {
				 System.out.print(i + ", ");
			 }
		 }
		System.out.println();
		/* Q10. Find the minimum of two numbers using ternary operators. */
		int intQ10A = 144;
		int intQ10B = -33;
		System.out.println("The min value of " + intQ10A + " and " + intQ10B + " is " + 
				MyMath.myMinimum(intQ10A, intQ10B));
		
		/* Q11. Write a program that would access two float-variables from a class that exists in another package. 
		 * Note, you will need to create two packages to demonstrate the solution.
		 */
		System.out.println("The sum of the two floats from a different package: " + (NonDescriptClass.f1 + 
				NonDescriptClass.f2));
	 
		/* Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the 
		 * array. Use the enhanced FOR loop for printing out the numbers.
		 */
		System.out.println("Printing array of evens from 1 to 100 with for-each loop: ");
		MyMath.printArrayEvens();
		
		/* Q13. Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of 
		 * print statements to accomplish this.
		 * 
		 */
		int intQ13 = 4;
		Miscellaneous.printTriangle(intQ13);
		
		/* Q14. Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
		 * Case 1: Find the square root of a number using the Math class method. 
         * Case 2: Display today’s date.
		 * Case 3: Split the following string and store it in a sting array. 
		 * “I am learning Core Java”
		 */
		String command = "";
		Scanner scan = new Scanner(System.in);
		System.out.println("\nEnter command (<square root>, <date>, <split>)");
		command = scan.nextLine();
		switch(command) {
		case "square root" : 
			int num; 
			System.out.println("Enter your value");
			num = Integer.parseInt(scan.nextLine());
			System.out.println(Math.sqrt(num));
			break;
		case "date" :
			System.out.println(new java.util.Date());
			break;
		case "split" :
			String str = "I am learning Core Java";
			System.out.println("The original string is " + str + "\nNow spliting!");
			String first = str.substring(0, (str.length()-1)/2);
			String second = str.substring((str.length()-1)/2, str.length());
			System.out.println("First array: " + first + "\tSecond Array: " + second);
		default :
			System.out.println("command not recognized");
		}
		scan.close();
	}
	
}

