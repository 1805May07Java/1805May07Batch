package com.hw.q8;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class PalindromesTest {

	@Test
	void test() {
		
		
		
		ArrayList<String> wordList = new ArrayList<String>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"));
		ArrayList<String> palindromes = new ArrayList<String>(Arrays.asList("madam","civic", "radar", "sexes", "kayak",  "refer", "did"));
		
		
		assertEquals(palindromes, Palindromes.palindromes(wordList) );
	}

}
