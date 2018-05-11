package com.rev.Q4;

import static org.junit.Assert.*;

import org.junit.Test;

public class NFactorialTest {

	@Test
	public void test() {
		int res = NFactorial.factN(5);
		assertEquals(120, res);
		res = NFactorial.factN(8);
		assertEquals(40320, res);
	}

}
