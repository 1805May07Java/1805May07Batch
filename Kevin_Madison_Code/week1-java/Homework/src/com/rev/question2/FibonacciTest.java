package com.rev.question2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FibonacciTest {

	Fibonacci f;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		f = new Fibonacci();
	}

	@AfterEach
	void tearDown() throws Exception {
		f = null;
	}

	@Test
	void test() {
		int[] fib = new int[25];
		int[] expected = {0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765,10946,17711,28657,46368};
		
		fib = f.populateFibNumbers(fib);
		
		for(int i = 0; i<fib.length ; i++) {
			assertEquals(fib[i], expected[i]);
		}
		
		
	}

}
