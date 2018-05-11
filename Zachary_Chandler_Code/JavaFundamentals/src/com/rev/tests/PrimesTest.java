package com.rev.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.rev.questions.Primes;

class PrimesTest {

	@Test
	void test100Primes() {
		int[] correct = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
		
		ArrayList<Integer> result = Primes.primes(100);
		
		assertEquals(result.size(), correct.length);
		
		for (int i = 0; i < correct.length; i++) {
			int x = result.get(i);
			assertEquals(x, correct[i]);
		}
	}

}
