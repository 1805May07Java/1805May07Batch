package com.revature.exercise2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FibonacciTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before method");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After method");
	}

	@Test
	public void test() {
		System.out.println("IN TEST METHOD");
		long actual = Fibonacci.fibonacciSequence(5);
		long expected = 5L;
		assertEquals(actual, expected);
		assertEquals(Fibonacci.fibonacciSequence(6), 8);
	}

	@Test
	public void badTest() {
		System.out.println("IN BAD TEST");
		assertNotEquals(Fibonacci.fibonacciSequence(6), 5L);
	}
}
