package com.rev.fib;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FibonacciTest {
	
	Fibonacci f; 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("before");
		Fibonacci f = new Fibonacci();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after");
		f = null;
	}

	@Test
	public void test() {
		int actual = Fibonacci.fib(5); // 
		int expected = 5;
		assertEquals(actual, expected);
		assertEquals(f.fib(6), 5);
	}
	
	@Test
	public void badTest() {
		assertNotEquals(f.fib(6), 5);
	}

}
