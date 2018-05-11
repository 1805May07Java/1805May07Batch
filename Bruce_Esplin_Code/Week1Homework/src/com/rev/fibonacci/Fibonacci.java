package com.rev.fibonacci;

public class Fibonacci {
	 
	public static void main(String[] args) {
		Fibonacci();
	}
	
	public static void Fibonacci(){
		//Set number count. Initialize first two numbers.  
        int count = 25, n1 = 0, n2 = 1;
               
        //Loop through count.
        for (int i = 1; i <= count; ++i)
        {
        	//Print results.
            System.out.print(n1+" ");

            /* Each pass through the loop, the second number
             * is assigned to the first number and the sum of the last two
             * numbers is assigned to the second number
             */
            int sumOfPrevTwo = n1 + n2;
            n1 = n2;
            n2 = sumOfPrevTwo;
        }
	}
}

	