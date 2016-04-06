package com.antibyteapps.dictionary.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Orhun Dalabasmaz
 */
public class Node {
	private char letter;
	private boolean isWord;
	private List<Node> subnodes = new ArrayList<>();

	public Node() {
		this.letter = '-';
	}

	public Node(char letter) {
		this.letter = letter;
	}

	public char getLetter() {
		return letter;
	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord() {
		isWord = true;
	}

	public List<Node> getSubnodes() {
		return subnodes;
	}

	/* */
	public Node findSubnode(char letter) {
		for (Node node : subnodes) {
			if (node.letter == letter)
				return node;
		}
		return null;
	}

	public void addSubnode(Node node) {
		subnodes.add(node);
	}

	public void addWord(String word) {
		if (word == null || word.isEmpty()) {
			setWord();
			return;
		}
		char letter = word.charAt(0);
		String remaining = word.substring(1);

		Node node = findSubnode(letter);
		if (node == null) {
			node = new Node(letter);
			addSubnode(node);
		}
		node.addWord(remaining);
	}

	public boolean isWord(String word) {
		if (word == null || word.isEmpty()) return false;
		char letter = word.charAt(0);
		String remaining = word.substring(1);

		Node node = findSubnode(letter);
		if (node == null) return false;
		if (remaining.isEmpty()) return node.isWord;
		return node.isWord(remaining);
	}

	@Override
	public String toString() {
		return Character.toString(letter);
	}
}
