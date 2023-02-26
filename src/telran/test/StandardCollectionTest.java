package telran.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.util.StackInt;

class StandardCollectionTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Disabled
	@Test
	void subListTest() {
		List<Integer> mutableList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 70, -20));
		mutableList.add(5);
		List<Integer> subList = mutableList.subList(6, 9);
		System.out.println(subList);
		subList.add(1, -2);
		subList.sort(Integer::compare);
		System.out.println(subList);
		System.out.println(mutableList);
	}
	
	@Test
	@Disabled
	void dispayOccurrencesCounter() {
		String[] strings = {"lmn", "abc", "abc", "lmn", "a", "lmn"};
		Arrays.stream(strings).collect(Collectors.groupingBy(s -> s, Collectors.counting()))
		.entrySet().stream().sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
		.forEach(a -> System.out.printf("%s: %d\n", a.getKey(), a.getValue()));
	}
	
	@Test
	@Disabled
	void displayDigitStatistics() {
		//Generate 1_000_000 random numbers in [1, Integer.MAX_VALUE)
		//Display digits and counters of their occurrences in descending order of the counts
		//consider using flatMap
		new Random().ints(1_000_000, 1, Integer.MAX_VALUE).flatMap(num -> Integer.toString(num).chars())
		.boxed().collect(Collectors.groupingBy(num -> num, Collectors.counting()))
		.entrySet().stream().sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
		.forEach(elem -> System.out.printf("%c: %d\n", elem.getKey(), elem.getValue()));
	}
	
	@Test
	void maxNumberWithNegativeImageTest() {
		int[] arr = {10000000, 3, -2, -200, 200, -3};
		int[] arr1 = {1000000, -1000000000, 3, -4};
		assertEquals(200, getMaxNumberWithNegativeImage(arr));
		assertEquals(-1, getMaxNumberWithNegativeImage(arr1));
	}
	
	int getMaxNumberWithNegativeImage(int[] array) {
		HashSet<Integer> hashSet = new HashSet<>();
		int res = -1;
		for (int num : array) {
			hashSet.add(num);
			if (hashSet.contains(-num)) {
				num = Math.abs(num);
				if (num > res) {
					res = num;
				}
			}
		}
		return res;
	}
	
	@Test
	void treeIteratingTest() {
		Integer[] array = {1, 11, 111, 32, 9, 1234, 99, 992};
		TreeSet<Integer> tree = createAndIterateTreeInOrder(array);
		Integer[] result = tree.toArray(new Integer[] {});
		assertArrayEquals(array, result);
	}

	private TreeSet<Integer> createAndIterateTreeInOrder(Integer[] array) {
		TreeSet<Integer> tree = new TreeSet<>((a, b) -> digitsSum(a) - digitsSum(b));
		for (Integer num : array) {
			tree.add(num);
		}
		return tree;
	}
	
	private int digitsSum(int number) {
		int result = 0;
		do {
			result += number % 10;
			number /= 10;
		} while (number != 0);
		return result;
	}
}
