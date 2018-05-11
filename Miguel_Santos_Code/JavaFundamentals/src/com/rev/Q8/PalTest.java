package com.rev.Q8;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalTest {

	@Test
	public void test() {
		String s1 = "kayak";
		String s2 = "oar";
		boolean res1 = Palindrome.isPal(s1);
		boolean res2 = Palindrome.isPal(s2);
		assertEquals(true, res1);
		assertEquals(false, res2);
	}

}
