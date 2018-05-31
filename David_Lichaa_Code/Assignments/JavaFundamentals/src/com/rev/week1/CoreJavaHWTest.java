package com.rev.week1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoreJavaHWTest {

	CoreJavaHW h;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//System.out.println("before class");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		//System.out.println("after class");
	}

	@BeforeEach
	void setUp() throws Exception {
		//System.out.println("before method");
	}

	@AfterEach
	void tearDown() throws Exception {
		//System.out.println("after method");
	}
	/* Test for Q2 fibonacci print*/
	@Test
	void fibonacciTest() {
		String fib5 = "0, 1, 1, 2, 3";  //Fibonacci sequence up to 5
		String fib8 = "0, 1, 1, 2, 3, 5, 8, 13"; //Fibonacci sequence up to 8
		String fib15 = "0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377";
		String fib25 = "0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946"
				+ ", 17711, 28657, 46368";
		assertEquals(fib5, MyMath.getFibonacci(5));
		assertEquals(fib8, MyMath.getFibonacci(8));
		assertEquals(fib15, MyMath.getFibonacci(15));
		assertEquals(fib25, MyMath.getFibonacci(25));
	}
	/* Test for Q3 reverse string */
	@Test 
	void stringReverserTest() {
		String s1 = "abcd1234";
		String s2 = "";
		String s3 = "111110";
		assertEquals("4321dcba", MyString.reverseString(s1));
		assertEquals("", MyString.reverseString(s2));
		assertEquals("011111", MyString.reverseString(s3));
	}
	/* Test for Q4 factorial */
	@Test 
	void factorialTest() {
		int n1 = 5;
		int n2 = 0;
		int n3 = 10;
		assertEquals(MyMath.factorial(n1), 120);
		assertEquals(MyMath.factorial(n2), 1);
		assertEquals(MyMath.factorial(n3), 3628800);
	}

	/* Test for Q5 substring */
	@Test
	void substringTest() {
		String s1 = "Revature";
		String s2 = "";
		assertEquals(s1.substring(0, 5), MyString.substring(s1, 5));
		assertEquals(s1.substring(0, 0), MyString.substring(s2, 0));
		assertEquals(s2.substring(0, 0), MyString.substring(s2, 0));
		assertEquals(s1.substring(0, s1.length() - 1), MyString.substring(s1, s1.length()-1));
	}
	/* Test for Q6 check even */
	@Test
	void isEvenTest() {
		int n1 = 2;
		int n2 = 1;
		int n3 = 0;
		int n4 = -1;
		int n5 = 10055;
		int n6 = 999;
		assertTrue(MyMath.isEven(n1));
		assertFalse(MyMath.isEven(n2));
		assertTrue(MyMath.isEven(n3));
		assertFalse(MyMath.isEven(n4));
		assertFalse(MyMath.isEven(n5));
		assertFalse(MyMath.isEven(n6));
		assertTrue(MyMath.isEven(n6 + 1));
	}

	/*  Test for Q8 palindrome helper function*/
	@Test
	void palindromeTest() {
		String s1 = "ABBA";
		String s2 = "ABCBA";
		String s3 = "aaa";
		String s4 = "fail";
		String s5 = "";
		assertTrue(MyString.isPalindrome(s1));
		assertTrue(MyString.isPalindrome(s2));
		assertTrue(MyString.isPalindrome(s3));
		assertFalse(MyString.isPalindrome(s4));
		assertTrue(MyString.isPalindrome(s5));
	}
	/* Test for Q9 test if given integer is prime */
	@Test
	public void testPrime() {
		assertTrue(MyMath.isPrime(3));
		assertTrue(MyMath.isPrime(5));
		assertTrue(MyMath.isPrime(7));
		assertTrue(MyMath.isPrime(97));
		assertFalse(MyMath.isPrime(2));
		assertFalse(MyMath.isPrime(100));
	}
	/* Test for Q10 if mininmum with ternary works correctly */
	@Test 
	void minimumTest() {

		assertEquals(Math.min(10, 5), MyMath.myMinimum(10, 5));
		assertEquals(Math.min(10, 10), MyMath.myMinimum(10, 10));
		assertEquals(Math.min(-3, 3), MyMath.myMinimum(-3, 3));
		assertEquals(Math.min(11, 8), MyMath.myMinimum(11, 8));

	}
}
