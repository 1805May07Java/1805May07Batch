package question06;

import java.util.Scanner;

public class CheckEven {
	//check the bits, last bit is one in even nums
	public static Boolean isEven(int x) {
		String binaryIntString = Integer.toBinaryString(x);
		int lastBit = binaryIntString.length() -1 ;
		if (binaryIntString.charAt(lastBit)==0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String [] args) {
		Scanner scanner = new Scanner( System.in );
		System.out.println("Enter number to check if even");
		String input = scanner.nextLine();
		int toCheck = Integer.parseInt(input);
		scanner.close();
			
		System.out.println(isEven(toCheck));
	}
}
