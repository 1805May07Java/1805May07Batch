package com.rev.questions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class exc8_arrayListTest {
	exc8_arrayList a;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		a = new exc8_arrayList();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//“karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
		a.sort("karma");
		a.sort("madam");
		a.sort("tom");
		a.sort("civic");
		a.sort("radar");
		a.sort("sexes");
		a.sort("jimmy");
		a.sort("kayak");
		a.sort("john");
		a.sort("refer");
		a.sort("billy");
		a.sort("did");
		System.out.print("Palindromes: ");
		for(int i = 0; i < a.getPalindromes().size(); i++) {
			System.out.print(a.getPalindromes().get(i) + " ");
		}
		System.out.print("\nList: ");
		for (int i = 0; i < a.getList().size(); i++) {
			System.out.print(a.getList().get(i) + " ");
		}
	}

}
