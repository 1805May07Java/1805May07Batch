package com.hw.q13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTriangle {
	
	Triangle tester = new Triangle();

	@Test
	void test() {
		assertEquals("0 \n" + 
				"1 0 \n" + 
				"1 0 1 \n" + 
				"0 1 0 1 \n",  tester.triangleOfHeight(4));
	}

}
