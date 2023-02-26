package telran.util;

import java.util.HashMap;

public class MyArrayInt {
	HashMap<Integer, Integer> map;
	int defaultValue;
	int size;
	
	public MyArrayInt(int size, int value) {
		this.size = size;
		defaultValue = value;
	}
	
	public void set(int index, int value) {
		checkIndex(index);
		if (map == null) {
			map = new HashMap<>();
		}
		map.put(index, value);
	}
	
	public int get(int index) {
		checkIndex(index);
		Integer res = defaultValue;
		if (map != null) {
			res = map.getOrDefault(index, defaultValue);
		}
		return res;
	}
	
	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public void setAll(int value) {
		defaultValue = value;
		map = null;
	}
}
