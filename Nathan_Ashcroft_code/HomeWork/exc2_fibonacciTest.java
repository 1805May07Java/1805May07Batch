package com.rev.questions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class exc2_fibonacciTest {

	exc2_fibonacci f;
	
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
		System.out.println("before methed");
		f = new exc2_fibonacci();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("\nafter method");
		f = null;
	}

	@Test
	public void test() {
		System.out.println("in test");
		int degree = 25;
		int[] array = new int[degree];
		array = f.fib(array);
		for(int i = 0; i < degree - 1; i++) {
			System.out.print(array[i]);
			System.out.print(" ");
		}
	}

}
