package com.rev.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangMan {
	
	public static void main(String[] args) {
		Random r = new Random();
		
		List<String> dictionary;
		
		try {
			dictionary = getDictionary();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find dictionary. Now exiting.");
			return;
		}
		
		String word = dictionary.get(r.nextInt(dictionary.size()));
		
		game(word, 5);
	}
	
	static void game(String word, int guessesLeft) {
		
		System.out.println("Welcome to hangman! Let's begin,");
		
		Comparator<Character> comp = (o1, o2) -> o1 - o2;
		
		boolean win = false;
		Scanner scan = new Scanner(System.in);
		List<Character> guesses = new LinkedList<>();
		String original = word;
		word = word.toLowerCase();
		HangManTextArt art = new HangManTextArt();
		
		while (!win && guessesLeft > 0) {
			guesses.sort(comp);
			
			System.out.println(art);
			System.out.printf("Word: %s\n", displayWord(original, guesses));
			System.out.printf("Guesses: %s\n", guesses);
			System.out.printf("You have %d guesses left\n", guessesLeft);
			System.out.print("Guess a letter: ");
			
			String line = scan.nextLine().toLowerCase();
			
			if (line.length() > 1 || line.length() <= 0 || !Character.isAlphabetic(line.charAt(0))) {
				System.out.println("That wasn't a letter!");
				System.out.println();
				continue;
			}
			
			char c = line.charAt(0);
			
			if (guesses.contains(c)) {
				System.out.println("You already guessed that!");
				System.out.println();
				continue;
			}
			
			System.out.println();
			
			if (word.indexOf(c) != -1) {
				System.out.println("Correct!");
			} else {
				System.out.println("Incorrect!");
				guessesLeft--;
				art.setErrors(HangManTextArt.MAX_ERRORS-guessesLeft);
			}
			
			guesses.add(c);
			
			win = win(word, guesses);
			System.out.println();
		}
		
		if (guessesLeft > 0) {
			System.out.println(art);
			System.out.printf("Word: %s\n", displayWord(original, guesses));
			System.out.println("YOU WIN!");
		} else {
			System.out.println(art);
			System.out.println("YOU LOSE");
			System.out.printf("The word was: %s\n", word);
		}

		scan.close();
	}
	
	public static boolean win(String word, List<Character> guesses) {
		
		for (int i = 0; i < word.length(); i++) {
			if (!guesses.contains(word.charAt(i))) {
				return false;
			}
		}
		
		return true;
	}
	
	public static String displayWord(String original, List<Character> guesses) {
		
		String word = original.toLowerCase();
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < word.length(); i++) {
			if (guesses.contains(word.charAt(i))) {
				result.append(original.charAt(i));
			} else {
				result.append('_');
			}
			
			result.append(' ');
		}
		
		return result.toString();
	}
	
	/**
	 * @return a list of strings representing the dictionary.
	 * @throws FileNotFoundException if the dictionary cannot be found.
	 */
	public static List<String> getDictionary() throws FileNotFoundException {
		List<String> result = new LinkedList<String>();
		Scanner s = new Scanner(new File("src/com/rev/hangman/dictionary.txt"));
		
		while (s.hasNextLine()) {
			result.add(s.nextLine());
		}
		
		s.close();
		
		return result;
	}
	
}
