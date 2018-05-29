package com.hw.q14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hw.q14.Switch.InvalidInputException;

class TestSwitchCases {

	@Test
	void test1() {
		Switch test = new Switch();		
		assertEquals( Double.toString(Math.sqrt(2)),test.demo(1));
	}
	
	@Test
	void test2()
	{
		Switch test = new Switch();		
		assertEquals( "28/05/18",test.demo(2));
	}
	
	@Test
	void test3() {
		Switch test = new Switch();		
		assertArrayEquals(new String[] {"I", "am", "learning", "Core", "Java"}, test.getArray());
	}
	
	@Test
	void testException(){
		Switch test = new Switch();	
		assertThrows(InvalidInputException.class, () -> test.demo(4));
	}

}
