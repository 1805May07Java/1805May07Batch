package com.rev.Q3;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseTest {

	@Test
	public void test() {
		String res = Reverse.ReverseStr("hello");
		assertEquals("olleh", res);
		res = Reverse.ReverseStr("I am Miguel");
		assertEquals("leugiM ma I", res);
	}

}
