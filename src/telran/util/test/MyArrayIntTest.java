package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.MyArrayInt;

class MyArrayIntTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void MyArrayTest() {
		MyArrayInt array = new MyArrayInt(10, 5);
		assertEquals(5, array.get(5));
		array.set(5, 10);
		assertEquals(10, array.get(5));
		assertThrowsExactly(IndexOutOfBoundsException.class, () -> array.get(10));
		array.setAll(25);
		assertEquals(25, array.get(5));
		assertEquals(25, array.get(0));
	}

}
