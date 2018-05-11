package com.ex.hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Play
{

	public static void main(String[] args)
	{

		//Scanner object allows user input
		Scanner menu = new Scanner(System.in);
		//exit variable
		int exit = 0;
		
		
		System.out.println("Welcome to Hangman! Let's begin:");
		
		while(exit == 0) 
		{
			
			//let's play
			guess(generate());
			
			//exit query
			System.out.println("Thanks for playing would you like to play again?");
			System.out.println("If so press H to continue, or press any key to exit");
		
			//receive input 
			String input = menu.nextLine();
			
			//check if they want to quit 
			if(input.charAt(0) != 'h' && input.charAt(0) != 'H') 
			{
					
				exit = 1;
					
			}
		
		
		}
		
		menu.close();
		
	}



	static void guess(String word) 
	{
		//a list of valid input, basically is it a letter
		String valid = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		//set up the string for wrong guesses
		String wrong = "";
		
		//set up the char array for display to user
		char[] guessed = new char[word.length()];
		
		//generate starting picture
		for(int i = 0; i < word.length(); i++) 
		{

			guessed[i] = '_';

		}
		
		//Scanner object allows user input
		Scanner scan = new Scanner(System.in);
		
		// set the number of guesses
		int attempts = 5;
		
		
		
		//the game loop
		while(attempts > 0) 
		{
			
			//prints the board
			System.out.println(toprint(guessed));
			//prompts user
			System.out.println("Guess a letter");
			System.out.println("Attempts remaining: " + attempts);
			//receive input
			String letter = scan.nextLine();
			
			//checks to make sure it is a letter
			if(valid.contains(letter))
			{
				//makes it all lower case for easy check
				letter = letter.toLowerCase();
				
				if(!wrong.contains(letter)) 
				{
					if(word.contains(letter)) 
					{
						for(int i = 0; i < word.length(); i++) 
						{
							if(word.charAt(i)==letter.charAt(0)) 
							{
								guessed[i] = letter.charAt(0);
							}
						}
					}
					else 
					{
						//add to the list of guesses
						wrong += letter + " ";
						//inform user
						System.out.println("WRONG!! Your guesses are: " + wrong);
						attempts--;
		
					}
					
					//winning exit condition
					if(String.valueOf(guessed).equals(word)) 
					{
						attempts = -1;
					}
				}
				else
				{
					System.out.println("You already guessed that. Minus one Attempt.");
					attempts--;
				}
			}
			else
			{
				System.out.println("That is not a valid input minus one attempt, please select a letter.");
				attempts--;
			}
		}
		
		
		//win or loss message
		if(attempts == -1) 
		{
			System.out.println("Congrats! You win. Your word is " + word);
		}
		else 
		{
			System.out.println("You are DEFEATED!");
			System.out.println("The Word was " + word);
		}
		
		//close the scanner
		scan.close();
	}

	
	//quick conversion method, from char array to string
	public static String toprint(char[] letters) 
	{
		//what is returned
		String ret = "";

		
		//turns the char array into a string, with spaces
		for(char c : letters) {

			ret += c + " ";

		}

		return ret;

	}
	
	//generator method for picking the word to use
	public static String generate() 
	{
		String path = "src\\com\\ex\\hangman\\dictionary.txt";
		ArrayList<String> pool = new ArrayList<String>();
		String line = "";
		
		
		try 
		{
			//loading the file
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			//reading the file
			while((line = reader.readLine()) != null) 
			{
			pool.add(line);
			}
			
			//selecting the word, then returning
			line = pool.get((int)(Math.random() * pool.size()));
			reader.close();
			return line;
			
		} 
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
			
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
		
		return "";
			
		
	}
}
