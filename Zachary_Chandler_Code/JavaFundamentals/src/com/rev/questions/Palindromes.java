package com.rev.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palindromes {
	
	public static void main(String[] args) {
		String[] foo = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"};

		List<String> result1 = Arrays.asList(foo);
		List<String> result2 = new ArrayList<>();
		
		for (String s : result1) {
			if (s.equals(new StringBuilder(s).reverse().toString())) {
				result2.add(s);
			}
		}
		
		System.out.println(result2);
	}
	
	
}
