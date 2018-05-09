package question05;

import java.util.Scanner;

public class SubString {
	public static void main(String [] args) {
		Scanner scanner = new Scanner( System.in );
		System.out.println("Enter full string");
		String input = scanner.nextLine();
		String fullString = input;
		System.out.println("Enter start index of substring");
		input = scanner.nextLine();
		int startIndex = Integer.parseInt(input);
		System.out.println("Enter end index of substring");
		input = scanner.nextLine();
		int endIndex = Integer.parseInt(input);
		scanner.close();
		
		if(startIndex>endIndex) {
			int temp = startIndex;
			startIndex = endIndex;
			endIndex = temp;
		} else if(startIndex == endIndex) {
			System.exit(0);
		}
		
		String subString = "";
		for(int i = startIndex; i<endIndex+1; i++) {
			subString += fullString.charAt(i);
		}
		
		System.out.print(subString);
	}
}
