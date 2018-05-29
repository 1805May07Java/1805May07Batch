package com.hw.q11a;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPackages {

	@Test
	void testPi() {
		assertEquals(3.0f, FloatsClass.getPi());
	}
	
	@Test
	void testBetterPi() {
		assertEquals(3.14f, FloatsClass.getBetterPi());
	}

}
