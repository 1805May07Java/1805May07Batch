package test;

import java.util.Scanner;

public class MainTest {

	 public static void main(String[] args)
	    {
	        // Initialize variables
	        int N = 0; 
	        int max; 
	        int yourGuess = 0; 
	        int randomNumber = 0; 
	        int playAgain; 
	        
	        Scanner keyboardInput = new Scanner( System.in );   ///keep scanner in in
	        
	        do 
	        { 
	            // User input N
	            System.out.println( "\n" );
	            System.out.print("1.Choose a positive integer: ");
	            N = keyboardInput.nextInt(); 
	        
	            // Algebra to call variable "randomNumber"                  
	            randomNumber = (int) (N * Math.random() + 1); 

	            // User input "max" for number of guesses
	            System.out.println( "\n" );
	            System.out.print("2.Choose maximum number of guesses you would like to make: ");
	            max = keyboardInput.nextInt(); 
	            
	            //PROBLEM~~~, if choosing max could skip the whole while.........

	            while (yourGuess != randomNumber & max > 0) 
	            {
	                // Generate random number between 1 and N                   
	                System.out.println( "\n" );
	                System.out.print("3.Guess an integer between 1 and " + N + ": ");
	                yourGuess = keyboardInput.nextInt();  
	                
	                if(yourGuess == randomNumber) // Note no semicolon
	                {
	                    System.out.println("CORRECT!!!");
	                    yourGuess = 0; //<---DEBUG@ 
	                    break; // Keep here just in case of future code alterations
	                }
	                else if (yourGuess < randomNumber) // Note no semicolon 
	                {
	                    max -= 1;
	                    System.out.println("Too low");
	                    System.out.println();
	                    System.out.println("You have "+ max + " guess(es) left.");
	                    yourGuess = 0; //<---DEBUG@ 
	                }
	                else if (yourGuess > randomNumber) 
	                {
	                    max -=1;
	                    System.out.println("Too high");
	                    System.out.println("You have "+ max + " guess(es) left."); 
	                    yourGuess = 0; //<---DEBUG@ 
	                } 
	                /*
	                 * DEBUG@: reset yourGuess, else  while (yourGuess != randomNumber 
	                 * & max > 0) will compare past loop's yourGuess with newly 
	                 * input randomNumber. 
	                 */
	            }
	            // User input to replay or not
	            System.out.println(); 
	            System.out.print("I was thinking of number " + randomNumber + 
	                    "! Would you like to play again? \n (Type 1 for yes or 0 for no): ");
	            playAgain = keyboardInput.nextInt();         
	        }
	        while(playAgain == 1);
	        
	        if(playAgain == 0) 
	        {
	            System.out.println("See you next time!"); 
	            keyboardInput.close(); 
	        } 
	        else if(playAgain !=0 && playAgain !=1)
	        {
	            System.out.println("Wrong input, rerun this program again!"); // CURRENTLY ONLY WORKS FOR INTEGERS
	        }
	    }  
}
