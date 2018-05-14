package com.rev.exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FibonacciTest {

	Fibonacci f;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("before method");
		f = new Fibonacci();
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("after method");
		f = null;
	}

	@Test
	void test() {
		System.out.println("IN TEST METHOD");
		int actual = f.fib(5);
		int expected = 3;
		assertEquals(actual, expected);
		assertEquals(f.fib(6), 5);
	}
	
	@Test
	public void badTest() {
		System.out.println("IN BAD TEST");
		assertNotEquals(f.fib(6), 5);
	}

}
