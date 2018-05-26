package com.rev.exercise03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Q3_StringReversalTest {

	static Q3_StringReversal main;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		main = new Q3_StringReversal();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		main = null;
	}

	@Test
	void inputNullTest()
	{	
		String a = null;
		String rev = main.reverseString(null);
		assertEquals("String is Null", rev);
	}
	
	@Test
	void inputEmptyTest()
	{	
		String a = "";
		String rev = main.reverseString(a);
		assertEquals("", rev);
		
		a = "   ";
		rev = main.reverseString(a);
		assertEquals("   ", rev);
	}
	
	@Test
	void basicCharacterInputTest()
	{	
		String a = "reverse";
		String rev = main.reverseString(a);
		assertEquals("esrever", rev);
		
		a = "Reverse";
		rev = main.reverseString(a);
		assertEquals("esreveR", rev);
	}
	
	@Test
	void largeInputTest()
	{	
		String a = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		String rev = main.reverseString(a);
		assertEquals("zyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcba", rev);
	}
	
	@Test
	void SpacesAndNewlinesTest()
	{	
		String a = "This Sentence Has Spaces In It";
		String rev = main.reverseString(a);
		assertEquals("tI nI secapS saH ecnetneS sihT", rev);
		
		a = "This Sentence \n has a few \n new lines";
		rev = main.reverseString(a);
		System.out.println(rev);
		assertEquals("senil wen \n wef a sah \n ecnetneS sihT", rev);
	}
}
