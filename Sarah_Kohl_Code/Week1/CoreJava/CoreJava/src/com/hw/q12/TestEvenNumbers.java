package com.hw.q12;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class TestEvenNumbers {

	@Test
	void test() {
		
		ArrayList<Integer> firstHundred = new ArrayList<Integer>();
		ArrayList<Integer> firstHundredEvens = new ArrayList<Integer>();
		
		IntStream.range(1, 100).forEachOrdered(n -> {
		    firstHundred.add(n);
		});
		
		IntStream.range(1, 50).forEachOrdered(n -> {
		    firstHundredEvens.add(n*2);
		});
		
		
		
		assertEquals(firstHundredEvens, EvenNumbers.evenNumbers(firstHundred));
	}

}
