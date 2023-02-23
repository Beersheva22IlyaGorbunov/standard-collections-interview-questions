package telran.util;

import java.util.LinkedList;

public class StackInt {
	private LinkedList<Integer> numbers = new LinkedList<>();
	private LinkedList<Integer> maxValues = new LinkedList<>();
	
	public void push(int number) {
		numbers.add(number);
		if (maxValues.isEmpty() || number >= maxValues.getLast()) {
			maxValues.add(number);
		}
	}
	
	public int pop() {
		int num = numbers.removeLast();
		if (maxValues.getLast() == num) {
			maxValues.removeLast();
		}
		return num;
	}
	
	public boolean isEmpty() {
		return numbers.isEmpty();
	}
	
	public int getMax() {
		return maxValues.getLast();
	}
}
