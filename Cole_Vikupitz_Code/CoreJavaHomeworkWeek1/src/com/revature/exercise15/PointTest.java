/*
 * PointTest.java
 * Author: Cole Vikupitz
 * 
 * JUnit test cases for the Point class for exercise 15.
 */

package com.revature.exercise15;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.exercise7.Employee;

public class PointTest {
	
	Point p1, p2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	@Before
	public void setUp() throws Exception {
		p1 = new Point(5, 10);
		p2 = new Point(1, 2);
	}

	@After
	public void tearDown() throws Exception {
		p1 = p2 = null;
	}
	
	// Test Case 1
	@Test
	public void test1() {
		
		Point temp = p1.addition(p2);
		assertTrue(temp.getX() == 6 && temp.getY() == 12);
	}
	
	// Test Case 2
	@Test
	public void test2() {
	
		Point temp = p1.subtraction(p2);
		assertTrue(temp.getX() == 4 && temp.getY() == 8);
	}
	
	// Test Case 3
	@Test
	public void test3() {
		
		Point temp = p1.multiplication(p2);
		assertTrue(temp.getX() == 5 && temp.getY() == 20);
	}
	
	// Test Case 4
	@Test
	public void test4() {
		
		Point temp = p1.division(p2);
		assertTrue(temp.getX() == 5 && temp.getY() == 5);
	}
	

}
