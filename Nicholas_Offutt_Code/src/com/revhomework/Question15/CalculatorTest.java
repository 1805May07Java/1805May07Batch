package com.revhomework.Question15;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	Calculator test;
	
	
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		test = new Calculator();
	}

	@AfterEach
	void tearDown() throws Exception {
		test = null;
	}

	
	
	
	
	@Test
	void testAddition() {
		assertEquals(test.addition(6, 4), 10);
	}

	@Test
	void testSubtraction() {
		
		assertEquals(test.subtraction(7, 3), 4);
	}

	@Test
	void testMultiplication() {
		
		assertEquals(test.multiplication(16, 3), 48);
	}

	@Test
	void testDivision() {
		
		assertEquals(test.division(15, 5), 3);
	}

	@Test
	void testModulus() 
	{
		
		assertEquals(test.modulus(27, 8), 3);
	}

}
