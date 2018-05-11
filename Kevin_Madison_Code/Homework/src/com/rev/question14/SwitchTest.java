package com.rev.question14;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SwitchTest {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCase1() {
		int num = 16;
		double expected = 4.0;
		double observed = Switch.squareRoot(num);
		
		assertEquals(observed, expected);
	}
	
	@Test
	void testCase2() {
		String expected = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		String observed = Switch.todaysDate();
		
		assertEquals(observed, expected);
	}
	
	@Test
	void testCase3() {
		String str = "I am learning Core Java";
		String[] arr = Switch.splitIntoArray(str);
		String[] expected = {"I","am","learning","Core","Java"};
		
		for (int i = 0; i < arr.length; i++) {
			assertEquals(arr[i], expected[i]);
			
		}
		
	}

}
