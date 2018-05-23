package com.ex.hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Play {
	public static void main(String[] args) {
		System.out.println("Welcome to Hangman! Lets begin: ");
		boolean replay = true;
		
		//TODO: fix replay loop, does not replay when "y" is entered.
		while (replay) {
			guess(getWord());
			System.out.println("Play again? [type 'y' to play again]");

			Scanner keyboard = new Scanner(System.in);
			String response = keyboard.nextLine();
			
			replay = false;
			if (response.toLowerCase().equals("y")) {
				replay = true;
			}
		}
		
	}

	static void guess(String word) {
		String wrong = "";
		char[] guessed = new char[word.length()];
		int numGuesses = 0;
		for (int i = 0; i < word.length(); i++) {
			guessed[i] = '_';
		}
		String letter = "";
		
		//main game loop
		while (!String.valueOf(guessed).equals(word)) {
			boolean validInput = false;
			while (!validInput) {
				System.out.println(toprint(guessed));

				System.out.println("Guess a letter");

				validInput = true;
				// scanner object allows user input
				Scanner scan = new Scanner(System.in);
				letter = (scan.nextLine().toLowerCase());
				
				
				// Check for valid input
				if (!Character.isLetter(letter.charAt(0))) {
					validInput = false;
					System.out.println("Has to be a letter!");
				}
				
				// check input length, must be a single letter
				if(letter.length()>1) {
					validInput = false;
					System.out.println(letter + " must be a single letter.");
				}
				
				//check if letter was already guessed
				for (int i = 0; i < guessed.length; i++) {
					if (guessed[i] == letter.charAt(0)) {
						validInput = false;
						System.out.println(letter.charAt(0)+" has already been guessed.");
					}
				}
				
				//check if the player has used 5 guesses
				if (numGuesses >= 5) {
					validInput = false;
					System.out.println("You've ran out of guesses, the word was: " + word);
					return;//return from loop
				}
				
				if(validInput)
					numGuesses++;
			}
			
			// check the word for letter(s) matching the player's guess
			if (word.contains(letter)) {
				for (int i = 0; i < word.length(); i++) {
					if (word.charAt(i) == letter.charAt(0)) {
						guessed[i] = letter.charAt(0);
					}
				}
			} else {// the player's guess is not in the word...
				wrong += letter + " ";
				System.out.println("Sorry! Your guesses are: " + wrong);
				System.out.println("You have '" +(5-numGuesses)+"' guess remaining.");
			}
		}

		System.out.println("You win! The word was: " + word);

	}

	static String toprint(char[] letters) {
		String ret = "";
		for (char c : letters) {
			ret += c + " ";
		}
		return ret;
	}

	static String getWord() {
		ArrayList<String> words = new ArrayList<String>();

		String path = "src/com/ex/hangman/words.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String currLine = null;
			while ((currLine = br.readLine()) != null) {
				words.add(currLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int rand = (int) (Math.random() * words.size() - 1);
		return words.get(rand);
	}
}
