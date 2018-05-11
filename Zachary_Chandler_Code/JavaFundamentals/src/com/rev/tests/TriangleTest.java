package com.rev.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.rev.questions.Triangle;

class TriangleTest {

	@Test
	void testExample() {
		assertEquals(Triangle.triangle(4), "0\n1 0\n1 0 1\n0 1 0 1\n");
	}

}
