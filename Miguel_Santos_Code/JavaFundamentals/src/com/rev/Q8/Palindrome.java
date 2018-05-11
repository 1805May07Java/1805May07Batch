package com.rev.Q8;

import java.util.ArrayList;

public class Palindrome {

	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		p.PalList();
	}
	
	ArrayList<String> words = new ArrayList<String>();
	ArrayList<String> palindromes = new ArrayList<String>();

	public void PalList() {
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("sexes");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("did");
		
		for(String s : words) {
			if (isPal(s))
				palindromes.add(s);
		}
		System.out.println("This is original list: "+ words);
		System.out.println("These are the palindromes: "+ palindromes);
	}

	public static boolean isPal(String s) {
		StringBuilder chk = new StringBuilder(s);
		if (s.equals(chk.reverse().toString()))
			return true;
		else
			return false;
	}



}
