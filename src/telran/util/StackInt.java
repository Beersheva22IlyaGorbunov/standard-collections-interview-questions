package telran.util;

import java.util.LinkedList;

public class StackInt {
	private LinkedList<Integer> list = new LinkedList<>();
	private LinkedList<Integer> maxValues = new LinkedList<>();
	
	public void push(int number) {
		list.add(number);
		if (maxValues.size() > 0 && maxValues.getLast() > number) {
			maxValues.add(maxValues.getLast());
		} else {
			maxValues.add(number);
		}
	}
	
	public int pop() {
		maxValues.removeLast();
		return list.removeLast();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int getMax() {
		return maxValues.getLast();
	}
}
