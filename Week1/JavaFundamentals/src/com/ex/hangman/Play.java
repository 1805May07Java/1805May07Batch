package com.ex.hangman;

import java.util.Scanner;

public class Play {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Hangman! Let's begin:");
		guess("test");
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

}
