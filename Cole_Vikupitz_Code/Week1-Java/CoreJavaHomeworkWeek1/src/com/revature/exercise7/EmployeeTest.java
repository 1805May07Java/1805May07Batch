/*
 * EmployeeTest.java
 * Author: Cole Vikupitz
 * 
 * JUnit test cases for the Employee compare function for exercise 7.
 */

package com.revature.exercise7;

// Imports
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeTest {
	
	Employee e1, e2, e3, e4;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	@Before
	public void setUp() throws Exception {
		e1 = new Employee("Cole", "Java", 23);
		e2 = new Employee("Jake", "Java", 30);
		e3 = new Employee("Mike", "Sales", 19);
		e4 = new Employee("Cole", "Java", 23);
	}

	@After
	public void tearDown() throws Exception {
		e1 = e2 = e3 = e4 = null;
	}
	
	// Test Case 1
	@Test
	public void test1() {
		assertTrue(e1.compare(e1, e2) < 0);
	}
	
	// Test Case 2
	@Test
	public void test2() {
		assertTrue(e3.compare(e3, e4) > 0);
	}
	
	// Test Case 3
	@Test
	public void test3() {
		assertTrue(e3.compare(e3, e2) > 0);
	}
	
	// Test Case 4
	@Test
	public void test4() {
		assertTrue(e1.compare(e1, e4) == 0);
	}

}
