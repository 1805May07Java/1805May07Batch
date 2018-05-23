package com.ex.hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Play {
	public static void main(String[] args) {
		boolean again = true;
		while(again) {
		System.out.println("welcome to hangman! Lets begin: ");
		
			guess(getWord());
			System.out.println("Do you want to play again?");
			
			Scanner scan = new Scanner(System.in);
			String letter = scan.nextLine().toLowerCase();
			again = false;
			if(letter.charAt(0) == 'y') {
				again = true;
			}
			scan.close();
		}
	}
	
	static void guess(String word) {
		String wrong = "";
		char [] guessed = new char[word.length()];
		int numGuesses = 0;
		for(int i = 0; i < word.length(); i++) {
			guessed[i] = '_';
		}
		String letter = "";
		while(!String.valueOf(guessed).equals(word)) {
			boolean inputOk = false;
			while(!inputOk) {
				System.out.println(toprint(guessed));
				
				System.out.println("Guess a letter");
				
				inputOk = true;
				//scanner object allows user input
				Scanner scan = new Scanner(System.in);
				
				letter = (scan.nextLine().toLowerCase());
				scan.close();
				if (!Character.isLetter(letter.charAt(0))){
					inputOk = false;
					System.out.println("Has to be a letter!");
				}
				for(int i = 0; i < guessed.length; i++) {
					if (guessed[i] == letter.charAt(0)) {
						inputOk = false;
						System.out.println("already guessed that letter!");
					}
				}
				if (numGuesses > 5) {
					inputOk = false;
					System.out.println("You are out of guesses!!!! \nYou loose. \nThe word is: " + word);
					return;
				}
				numGuesses++;
			}
			if(word.contains(letter)) {
				for(int i = 0; i < word.length(); i++) {
					if(word.charAt(i)==letter.charAt(0)) {
						guessed[i] = letter.charAt(0);
					}
				}
			}
			else {
				wrong += letter + " ";
				System.out.println("WRONG!!!!!!! Your guesses are: " + wrong);
			}
		}
		
		System.out.println("Congrats! You Win. Your word is " + word);
			
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
}
