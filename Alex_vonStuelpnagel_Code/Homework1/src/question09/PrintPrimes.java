package question09;

import java.util.ArrayList;

public class PrintPrimes {
	
	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
		for (int i=0; i<101; i++) {
			arrList.add(i);
			
			boolean isPrime = true;
			int temp;
			for(int j=2; j<=i/2; j++) {
		       temp = i % j;
		       
			   if(temp==0) {
			      isPrime=false;
			      break;
			   }
			   
			}
			if(isPrime) {
				System.out.print(i + ", ");
			}
		}
	}
}
