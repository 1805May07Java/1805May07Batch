package com.rev.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import com.rev.questions.Fibonacci;

class FibonacciTest {

	@BeforeClass
	public static void setupBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public static void setup() throws Exception {
		
	}
	
	@After
	public static void tearDown() throws Exception {
		
	}
	
	@Test
	void fibonacciValidValuesTest() {
		assertEquals(Fibonacci.fibonacci(0), 0);
		assertEquals(Fibonacci.fibonacci(1), 1);
		assertEquals(Fibonacci.fibonacci(2), 1);
		assertEquals(Fibonacci.fibonacci(3), 2);
		assertEquals(Fibonacci.fibonacci(4), 3);
		assertEquals(Fibonacci.fibonacci(5), 5);
		assertEquals(Fibonacci.fibonacci(10), 55); 
		assertEquals(Fibonacci.fibonacci(19), 4181);
		assertEquals(Fibonacci.fibonacci(31), 1346269);
	}
	
	@Test
	void fibonacciInvalidValuesTest() {
		assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(-1));
		assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(-100));
	}
}
