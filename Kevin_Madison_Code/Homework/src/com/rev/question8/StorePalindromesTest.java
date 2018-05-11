package com.rev.question8;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StorePalindromesTest {
	StorePalindromes sp;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		//initialize variable
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> expected = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();
		
		//add to list
		list.add("karan");
		list.add("madam");
		list.add("tom");
		list.add("civic");
		list.add("radar");
		list.add("sexes");
		list.add("jimmy");
		list.add("kayak");
		list.add("john");
		list.add("refer");
		list.add("billy");
		list.add("did");
		
		//add to expected
		list.add("madam");
		list.add("civic");
		list.add("radar");
		list.add("sexes");
		list.add("kayak");
		list.add("refer");
		list.add("did");
		
		
		temp = StorePalindromes.palindromes(list);
		
		for (int i = 0; i < temp.size()-1; i++) {
			assertEquals(temp.get(i), expected.get(i));
		}
		
		
	}

}
