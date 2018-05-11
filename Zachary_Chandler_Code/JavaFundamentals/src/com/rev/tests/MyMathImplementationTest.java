package com.rev.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.rev.questions.MyMathImplementation;

class MyMathImplementationTest {

	@Test
	void testAdd() {
		MyMathImplementation math = new MyMathImplementation();

		assertEquals(math.add(1, 2), 3);
		assertEquals(math.add(-1, 2), 1);
		assertEquals(math.add(2, 2), 4);
	}

	@Test
	void testSub() {
		MyMathImplementation math = new MyMathImplementation();

		assertEquals(math.sub(1, 2), -1);
		assertEquals(math.sub(-1, 2), -3);
		assertEquals(math.sub(2, 2), 0);
		assertEquals(math.sub(4, 2), 2);
	}

	@Test
	void testDiv() {
		MyMathImplementation math = new MyMathImplementation();

		assertEquals(math.div(1, 2), 0);
		assertEquals(math.div(2, 2), 1);
		assertEquals(math.div(-2, 2), -1);
		assertEquals(math.div(4, 2), 2);
	}
	
	@Test
	void testDivideByZero() {
		MyMathImplementation math = new MyMathImplementation();

		assertThrows(ArithmeticException.class, () -> math.div(1, 0));
	}

	@Test
	void testMul() {
		MyMathImplementation math = new MyMathImplementation();

		assertEquals(math.mul(1, 0), 0);
		assertEquals(math.mul(0, 1), 0);
		assertEquals(math.mul(2, 2), 4);
		assertEquals(math.mul(-3, 2), -6);
		assertEquals(math.mul(5, 5), 25);
		assertEquals(math.mul(25, 1), 25);
		assertEquals(math.mul(1, 25), 25);
	}

}
