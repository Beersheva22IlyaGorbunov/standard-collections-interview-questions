package telran.structure;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MultiCountersImpl implements MultiCounters {
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
		
		map.forEach(null);
		map.put(item, ++res);
		addToSetInTree(item, res);
		return res;
	}

	private void removeFromTree(Object item, Integer key) {
		Set<Object> currentSet = tree.get(key);
		currentSet.remove(item);
		if (currentSet.isEmpty()) {
			tree.remove(key);
		}
	}

	private void addToSetInTree(Object item, Integer key) {
		HashSet<Object> set = tree.get(key);
		if (set == null) {
			set = new HashSet<>();
			tree.put(key, set);
		}
		set.add(item);	
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
		Entry<Integer, HashSet<Object>> maxItems = tree.lastEntry();
		return maxItems != null ? maxItems.getValue() : Collections.emptySet();
	}

}
