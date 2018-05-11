package question03;

import java.util.Scanner;

public class StringReverse {
	 public static String reverse(String str) 
	    {     
	        if ((str==null)||(str.length() <= 1) )
	            return str;
	        return reverse(str.substring(1)) + str.charAt(0);
	    }
	
	public static void main(String [] args) {
		Scanner scanner = new Scanner( System.in );
		System.out.println("Enter string to reverse");
		String input = scanner.nextLine();
		scanner.close();
		
		System.out.println(reverse(input));
	}
}
