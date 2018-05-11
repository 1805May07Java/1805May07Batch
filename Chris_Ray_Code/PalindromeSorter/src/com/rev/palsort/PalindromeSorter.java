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
	
	public static boolean isPal(String s){
	       
        //a base case
        if(s.length() == 1)
            return true;
       
        //another base case
        if(s.length() == 2 && s.charAt(0) == s.charAt(1))
            return true;
       
        //if the characters at the beginning and end of
        //the string are the same, then the method is called
        //again with those characters removed, so a shorter
        //and shorter string is produced with each call
        if(s.charAt(0) == s.charAt(s.length()-1))
            return isPal(s.substring(1, s.length()-1));
       
        return false;
       
    }

}
