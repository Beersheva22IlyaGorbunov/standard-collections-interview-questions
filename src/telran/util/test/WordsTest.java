package telran.util.test;

import org.junit.jupiter.api.Test;

import telran.util.Words;
import telran.util.WordsImpl;

public class WordsTest {
	@Test
	void wordsAddTest() {
		Words dictionary = new WordsImpl();
		dictionary.addWord("Equ");
		dictionary.addWord("Equb");
		dictionary.addWord("Equn");
		dictionary.addWord("Equbn");
		dictionary.addWord("Eq");
		dictionary.addWord("Abc");
		System.out.println(dictionary.getWordsByPrefix("Equb"));
	}
}
