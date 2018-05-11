package Q14;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Application {
 
	public static void main(String[] args) {
		// Q14. Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
		
		 
		}

	public void Menu(int i) {
		// TODO Auto-generated method stub
		int x=i;
		String s;
		switch(x) {
		case 1:
			System.out.println("Find the square root of a number using the Math class method. "+ Math.sqrt(2));
			break;
		case 2:
			LocalDate d =LocalDate.now();
			
			System.out.println("Display today’s date. "+ d );
			break;
		case 3: 
			System.out.println("Split the following string and store it in a sting array.");  
		    s="I am learning Core Java";
		    for(int j=0;j<s.split(" ").length;j++) {
		       System.out.println(s.split(" ")[j]);
		    }
		    break;
		
	}

	}

	
}
