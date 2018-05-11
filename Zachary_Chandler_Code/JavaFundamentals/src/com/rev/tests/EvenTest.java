package com.rev.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.rev.questions.Even;

class EvenTest {

	@Test
	void testEvens() {
		assertEquals(Even.even(0), "even");
		assertEquals(Even.even(2), "even");
		assertEquals(Even.even(30), "even");
		assertEquals(Even.even(-2), "even");
		assertEquals(Even.even(-56), "even");
	}

	@Test
	void testOdds() {
		assertEquals(Even.even(1), "odd");
		assertEquals(Even.even(31), "odd");
		assertEquals(Even.even(-3), "odd");
		assertEquals(Even.even(-51), "odd");
		assertEquals(Even.even(-1), "odd");
	}
	

}
