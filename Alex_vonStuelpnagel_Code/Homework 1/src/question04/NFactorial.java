package question04;

import java.util.Scanner;

public class NFactorial {
	public static void main(String [] args) {
		Scanner scanner = new Scanner( System.in );
		System.out.println("Enter number to be factorialized");
		String input = scanner.nextLine();
		scanner.close();
		int N = Integer.parseInt(input);	
		int sum = 0;
		for (int i=0; i<N+1 ; i++) {
			sum += i;
		}
		System.out.print(sum);
	}
}
