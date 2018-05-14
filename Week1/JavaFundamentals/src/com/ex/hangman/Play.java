package com.ex.hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Play {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Hangman! Let's begin:");
		guess(getWord());
	}

	static void guess(String word) {
		String wrong = "";
		char[] guessed = new char[word.length()];
		for(int i = 0; i < word.length(); i++) {
			guessed[i] = '_';
		}

		while(!String.valueOf(guessed).equals(word)) {
			
			System.out.println(toprint(guessed));
			
			System.out.println("Guess a letter");

			//Scanner object allows user input
			Scanner scan = new Scanner(System.in);

			String letter = scan.nextLine();

			if(word.contains(letter)) {
				for(int i = 0; i < word.length(); i++) {
					if(word.charAt(i)==letter.charAt(0)) {
						guessed[i] = letter.charAt(0);
					}
				}
			}
			else {
				wrong += letter + " ";
				System.out.println("WRONG!! Your guesses are: " + wrong);
			}
			
			

		}
		
		System.out.println("Congrats! You win. Your word is " + word);
	}
	
	static String toprint(char[] letters) {
		String ret = "";
		for(char c : letters) {
			ret += c + " ";
		}
		return ret;
	}
	
	static String getWord() {
		ArrayList<String> words = new ArrayList<String>();
		
		String path = "src/com/ex/hangman/words.txt";
		
		//Try with resources -- must implement Autocloseable 
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String currLine = null;
			while((currLine=br.readLine())!=null) {
				words.add(currLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int rand = (int) (Math.random() * words.size()-1);
		
		
		return words.get(rand);	
	}

	/*
	 * Add business rules to game
	 *  -- input validation
	 *  -- only allow 5 guesses
	 *  -- no duplicate guesses
	 *  -- loop to keep playing upon user request
	 *  -- case insensitive
	 *  -- theme game // separate by difficulty (optional)
	 */
}
