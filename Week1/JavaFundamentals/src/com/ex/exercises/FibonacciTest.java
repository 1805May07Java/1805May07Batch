package com.ex.exercises;

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
		System.out.println("before method");
		f = new Fibonacci();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after method");
		f = null;
	}

	@Test
	public void test() {
		System.out.println("IN TEST METHOD");
		int actual = f.fib(5);
		int expected = 3;
		assertEquals(actual, expected);
		assertEquals(f.fib(6), 5);
		assertNotEquals(f.fib(6), 5);
	}
	
	@Test
	public void badTest() {
		System.out.println("IN BAD TEST");
		assertNotEquals(f.fib(6), 5);
	}

}
