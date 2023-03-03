package telran.util;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class WordsImpl implements Words {
	TreeSet<String> addedString = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
	@Override
	public boolean addWord(String word) {
		return addedString.add(word);
	}

	@Override
	public List<String> getWordsByPrefix(String prefix) {
		return addedString.subSet(prefix, getPrefixLimit(prefix)).stream().collect(Collectors.toList());
	}
	
	private String getPrefixLimit(String prefix) {
		char lastChar = prefix.charAt(prefix.length() - 1);
		char newLastChar = (char)(lastChar + 1);
		return prefix.substring(0, prefix.length() - 1) + newLastChar;
	}

}
