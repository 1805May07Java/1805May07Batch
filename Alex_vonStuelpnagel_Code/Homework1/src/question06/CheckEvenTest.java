package question06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckEvenTest {

	@Test
	void test() {
		CheckEven ce;
		int checkEven = 2;
		boolean correct = true;
		assertEquals(ce.isEven(checkEven),correct);
		fail("Not yet implemented");
	}

}
