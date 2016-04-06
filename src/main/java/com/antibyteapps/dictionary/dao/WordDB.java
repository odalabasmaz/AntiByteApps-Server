package com.antibyteapps.dictionary.dao;

import com.antibyteapps.dictionary.common.DictionaryConstants;
import com.antibyteapps.dictionary.domain.WordWrapper;

/**
 * @author Orhun Dalabasmaz
 */
public class WordDB {
	private Node root;

	public WordDB() {
		this.root = new Node();
	}

	public void addWord(WordWrapper word) {
		if (word == null || !word.isRegular()) return;
		String value = word.getValue();
		root.addWord(value);
	}

	public boolean hasWord(String word) {
		if (word != null) {
			word = word.toLowerCase(DictionaryConstants.LOCALE_TR);
		}
		return root.isWord(word);
	}
}
