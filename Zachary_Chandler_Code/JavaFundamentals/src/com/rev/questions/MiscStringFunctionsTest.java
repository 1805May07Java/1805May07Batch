package com.rev.questions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MiscStringFunctionsTest {

	@Test
	void testContainsLowerCase() {
		MiscStringFunctions misc = new MiscStringFunctions.MiscStringFunctionsImp();

		assertEquals(misc.containsLowerCase("aA"), true);
		assertEquals(misc.containsLowerCase("Aa"), true);
		assertEquals(misc.containsLowerCase("aa"), true);
		assertEquals(misc.containsLowerCase("AA"), false);
	}

	@Test
	void testToUpperCase() {
		MiscStringFunctions misc = new MiscStringFunctions.MiscStringFunctionsImp();

		assertEquals(misc.toUpperCase("AlphaBeT"), "ALPHABET");
	}

	@Test
	void testAdd10() {
		MiscStringFunctions misc = new MiscStringFunctions.MiscStringFunctionsImp();

		assertEquals(misc.add10("21"), 31);
		assertEquals(misc.add10("-21"), -11);
	}
	
	@Test
	void testAdd10InvalidValues() {
		MiscStringFunctions misc = new MiscStringFunctions.MiscStringFunctionsImp();

		assertThrows(NumberFormatException.class, () -> misc.add10("2d1dfs2"));
	}

}
