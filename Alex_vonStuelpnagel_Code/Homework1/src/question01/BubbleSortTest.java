package question01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BubbleSortTest {
	BubbleSort b;
	@Test
	void test() {
		int [] toSort = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int [] correctOutput = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		
		b.bubbleSort(toSort);
		assertEquals(toSort,correctOutput);
		fail("Not yet implemented");
	}

}
