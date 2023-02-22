package telran.util.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import telran.util.StackInt;

public class StackIntTest {

	@Test
	void stackIntTest() {
		StackInt stack = new StackInt();
		assertThrowsExactly(NoSuchElementException.class, () -> stack.pop());
		stack.push(8);
		stack.push(2);
		stack.push(10);
		stack.push(12);
		stack.push(10);
		stack.push(12);
		stack.push(6);
		assertEquals(stack.pop(), 6);
		assertEquals(stack.getMax(), 12);
		stack.pop();
		assertEquals(stack.getMax(), 12);
		stack.pop();
		stack.pop();
		assertEquals(stack.getMax(), 10);
	}
}
