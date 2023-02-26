package telran.structure.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.structure.MultiCounter;

class MultiCounterTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void multiCounterTest() {
		MultiCounter multiCounter = new MultiCounter();
		assertEquals(1, multiCounter.addItem(5));
		assertEquals(2, multiCounter.addItem(5));
		assertEquals(2, multiCounter.getValue(5));
		assertEquals(1, multiCounter.addItem(2));
		assertEquals(2, multiCounter.addItem(2));
		assertArrayEquals(new Integer[] {2, 5}, multiCounter.getMaxItems().toArray());
		assertFalse(multiCounter.remove(10));
		assertTrue(multiCounter.remove(5));
		assertTrue(multiCounter.remove(2));
		assertArrayEquals(new Integer[] {}, multiCounter.getMaxItems().toArray());
	}

}
