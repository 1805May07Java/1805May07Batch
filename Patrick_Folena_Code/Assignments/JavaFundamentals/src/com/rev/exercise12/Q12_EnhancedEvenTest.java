package com.rev.exercise12;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Q12_EnhancedEvenTest {
	
	static Q12_EnhancedEven main;
	static int[] hold;
	private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		main = new Q12_EnhancedEven();
	    System.setOut(new PrintStream(outContent));
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		main = null;
	    System.setOut(System.out);
	}
	
	@AfterEach
	void afterEachTest() throws IOException
	{
		outContent.reset();
	}
	
	@Test
	void basicTest() {
		int[] hold = {10,11,12,13,14,15,16,17,18};
		main.printEven(hold);
		assertEquals("10 12 14 16 18", outContent.toString());
	}
	
	@Test
	void basicTestNeg() {
		int[] hold = {-10, -5, -3, 8, 2, 4, 1};
		main.printEven(hold);
		assertEquals("-10 8 2 4", outContent.toString());
	}
	
	@Test
	void testEmpty() {
		int[] hold = {};
		main.printEven(hold);
		assertEquals("", outContent.toString());
	}
	
	@Test
	void testNoEven() {
		int[] hold = {3, 5, 7, 9, 11};
		main.printEven(hold);
		assertEquals("", outContent.toString());
	}
	
	@Test
	void testHuge() {
		int[] hold = main.incIntArray(2000);
		main.printEven(hold);
		String test = "";
		for(int i = 1; i < 1000; i++)
		{
			test = test + (i*2) + " ";
		}
		test = test + "2000";
		assertEquals(test, outContent.toString());
	}

}
