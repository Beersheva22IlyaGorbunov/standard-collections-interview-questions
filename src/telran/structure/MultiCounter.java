package telran.structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class MultiCounter implements MultiCounters {
	Map<Object, Integer> map = new HashMap<>();
	NavigableMap<Integer, HashSet<Object>> tree = new TreeMap<>();

	@Override
	public Integer addItem(Object item) {
		Integer res = map.get(item);
		if (res == null) {
			res = 0;
		} else {
			removeFromTree(item, res);
		}
		map.put(item, ++res);
		addToSetInTree(item, res);
		return res;
	}

	private void removeFromTree(Object item, Integer key) {
		HashSet<Object> currentSet = tree.get(key);
		currentSet.remove(item);
		if (currentSet.isEmpty()) {
			tree.remove(key);
		}
	}

	private void addToSetInTree(Object item, Integer key) {
		HashSet<Object> foundedSet = tree.get(key);
		if (foundedSet == null) {
			HashSet<Object> newSet = new HashSet<>();
			newSet.add(item);
			tree.put(key, newSet);
		} else {
			foundedSet.add(item);
		}
	}

	@Override
	public Integer getValue(Object item) {
		return map.get(item);
	}

	@Override
	public boolean remove(Object item) {
		Integer res = map.remove(item);
		if (res != null) {
			removeFromTree(item, res);
		}
		return res == null ? false : true;
	}

	@Override
	public Set<Object> getMaxItems() {
		Set<Object> res = new HashSet<>();
		Entry<Integer, HashSet<Object>> maxItems = tree.lastEntry();
		if (maxItems != null) {
			res = maxItems.getValue();
		}
		return res;
	}

}
