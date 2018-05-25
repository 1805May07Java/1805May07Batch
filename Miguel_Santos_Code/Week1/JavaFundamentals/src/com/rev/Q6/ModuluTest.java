package com.rev.Q6;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModuluTest {

	@Test
	public void test() {
		String res = Modulu.mod(57);
		assertEquals("Odd", res);
		res = Modulu.mod(-188);
		assertEquals("Even", res);
	}

}
