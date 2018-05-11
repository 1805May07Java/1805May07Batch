package com.revhomework.Question2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FibonacciTest {

	Fibonacci f;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
		System.out.println("before all");
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception 
	{
		System.out.println("after all");
	}

	@BeforeEach
	void setUp() throws Exception 
	{
		System.out.println("before each");
		f = new Fibonacci();
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		System.out.println("After each");
		f = null;
	}

	@Test
	void test() 
	{
		System.out.println("IN TEST METHOD");
		int actual = f.fib(5);
		int expected = 5;
		assertEquals(actual, expected);
		assertEquals(f.fib(4), 3);
		assertEquals(f.fib(4), 5);
	}
	
	@Test
	public void badTest() 
	{
		System.out.println("IN BAD TEST");
		assertNotEquals(f.fib(5),5);
	}

}
