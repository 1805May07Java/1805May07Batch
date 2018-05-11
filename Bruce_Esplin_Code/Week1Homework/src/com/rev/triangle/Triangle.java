package com.rev.triangle;

public class Triangle {
	public static void main(String[] args) {
		//Initialize four rows and counter for completing triangle      
		int rows = 4;
		int counter = 0;     
		//Loop through rows
		for(int i = 1; i <= rows; ++i)
      {
			for(int j = 1; j <= i; ++j)
			{
				//Print the modulo of counter and increment
				System.out.print((counter %2) + " ");
				counter++;
		      }
        System.out.println("");
    }
   }
}

