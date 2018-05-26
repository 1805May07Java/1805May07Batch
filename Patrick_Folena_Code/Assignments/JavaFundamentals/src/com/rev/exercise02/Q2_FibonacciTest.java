package com.rev.exercise02;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Q2_FibonacciTest {

	static Q2_Fibonacci main;
	private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	    System.setOut(new PrintStream(outContent));
		main = new Q2_Fibonacci();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	    System.setOut(System.out);
		main = null;
	}
	
	@Test
	void inputInvalidTest()
	{	
		main.printFibonacciSequence(0);
		assertEquals("", outContent.toString());
		
		main.printFibonacciSequence(-20);
		assertEquals("", outContent.toString());
	}
	
	@Test
	void basicInputSequenceTest()
	{	
		main.printFibonacciSequence(10);
		assertEquals("0 1 1 2 3 5 8 13 21 34", outContent.toString());
	}
	
	void basicInputValueTest()
	{	
		main.Fibonacci(10);
		assertEquals("34", outContent.toString());
	}
	
	void largeInputValueTest()
	{
		main.Fibonacci(80);
		assertEquals("23416728348467685", outContent.toString());
	}
}
