package com.antibyteapps.dictionary.domain;

/**
 * @author Orhun Dalabasmaz
 */
public class WordWrapper {
	private String value;
	private boolean isLetter;
	private boolean isProperName;
	private boolean isPhrase;

	public WordWrapper(String value, boolean isLetter, boolean isProperName, boolean isPhrase) {
		this.value = value.toLowerCase();
		this.isLetter = isLetter;
		this.isProperName = isProperName;
		this.isPhrase = isPhrase;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isLetter() {
		return isLetter;
	}

	public boolean isProperName() {
		return isProperName;
	}

	public boolean isPhrase() {
		return isPhrase;
	}

	public boolean isRegular() {
		return !isLetter && !isProperName && !isPhrase;
	}
}
