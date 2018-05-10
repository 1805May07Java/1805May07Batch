package Q16;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		boolean flag=true;
		//Q16. Write a program to display the number of characters for a string input. 
		//The string should be entered as a command line argument using (String [ ] args).
		while(flag) {
			Scanner s=new Scanner(System.in);
			String str = s.nextLine();
			System.out.println(StringCount(str.toCharArray()));
			if (str.contains(".")) {
				flag=false;
				System.out.println("Input has stopped");
			}
		}
	}
       static int StringCount(char... str){
    	   return str.length;
       }
}
