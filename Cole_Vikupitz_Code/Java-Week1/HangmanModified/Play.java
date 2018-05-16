package com.ex.hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class Play {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Hangman! Let's begin:");
		guess(getWord());
	}
	
	// Fetch and return a random word from the dictionary
	static String getWord() {
		
		final int SIZE = 172822; // # of lines in dictionary
		BufferedReader reader = null;
		String word = null;
		try {
			reader = new BufferedReader(new FileReader("src/com/ex/hangman/words.txt"));
			int line = new Random().nextInt(SIZE); // Choose random line
			word = null;
			for (int i = 0; i <= line; i++) // Go to selected line
				word = reader.readLine();
			reader.close();
			return word.toLowerCase();
		} catch (Exception e) {
			return null;
		}
	}

	static void guess(String word) {
		String wrong = "";
		int tries = 9;
		char[] guessed = new char[word.length()];
		for(int i = 0; i < word.length(); i++) {
			guessed[i] = '_';
		}

		while(!String.valueOf(guessed).equals(word)) {
			
			System.out.println(toprint(guessed));
			
			System.out.println("Guess a letter");

			//Scanner object allows user input
			Scanner scan = new Scanner(System.in);

			String line = scan.nextLine();
			String letter = line.toLowerCase().substring(0, 1);

			// User already guessed this, restart loop
			if (wrong.contains(letter)) {
				System.out.println("You've already guessed that letter.");
				continue;
			}
			
			if (word.contains(letter)) {
				for(int i = 0; i < word.length(); i++) {
					if(word.charAt(i)==letter.charAt(0)) {
						guessed[i] = letter.charAt(0);
					}
				}
			}
			else {
				wrong += letter + " ";
				if (tries-- <= 0) {
					System.out.println("You are out of tries! Game Over!");
					System.out.printf("the word was %s\n", word);
					scan.close();
					return;
				}
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

}
