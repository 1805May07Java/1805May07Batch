package com.rev.palsort;

import java.util.ArrayList;
import java.lang.StringBuffer;
public class PalindromeSorter {

	public static void main(String[] args) {
		System.out.println("in main");
		ArrayList<StringBuffer> words = new ArrayList<StringBuffer>();
		words.add(new StringBuffer("karan"));
		words.add(new StringBuffer("madam"));
		words.add(new StringBuffer("tom"));
		words.add(new StringBuffer("civic"));
		words.add(new StringBuffer("radar"));
		words.add(new StringBuffer("sexes"));
		words.add(new StringBuffer("jimmy"));
		words.add(new StringBuffer("kayak"));
		words.add(new StringBuffer("john"));
		words.add(new StringBuffer("refer"));
		words.add(new StringBuffer("billy"));
		words.add(new StringBuffer("did"));
		ArrayList<StringBuffer> palindromes = new ArrayList<StringBuffer>();
		
		System.out.println(words);
		System.out.println(palindromes);
		for(int i = 0; i < words.size(); i++) {
			StringBuffer str2 = new StringBuffer(words.get(i));
			str2.reverse();
			System.out.println(words.get(i));
			System.out.println(str2);
			if(words.get(i).toString().equals(str2.toString())) {
				palindromes.add(words.get(i));
			}
		}
		System.out.println(words);
		System.out.println(palindromes);
	}

}
