package com.antibyteapps.services;

import com.antibyteapps.dictionary.service.DictionaryService;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * @author Orhun Dalabasmaz
 */
public class TestWords {
	private static DictionaryService DICTIONARY;
	private static ClientService CLIENT;

	private void initDictionary() {
		if (DICTIONARY == null) {
			DICTIONARY = DictionaryService.getInstance();
		}
	}

	private void initClientService() {
		if (CLIENT == null) {
			CLIENT = ClientService.getInstance();
		}
	}

	@Test
	public void testWords() {
		initDictionary();
		assertEquals(DICTIONARY.isWord("aba"), true);
		assertEquals(DICTIONARY.isWord("abaş"), false);
		assertEquals(DICTIONARY.isWord("abay"), false);
		assertEquals(DICTIONARY.isWord("abayı"), false);
		assertEquals(DICTIONARY.isWord("abar"), false);
		assertEquals(DICTIONARY.isWord("abart"), false);
		assertEquals(DICTIONARY.isWord("abartı"), true);
	}

	@Test
	public void testWordsViaServices() {
		initClientService();
		assertTrue(CLIENT.plainRequest().equals("You should give me a word to check!"));
		assertTrue(CLIENT.plainRequest("aba").equals("true"));
		assertTrue(CLIENT.plainRequest("abaş").equals("false"));
		assertTrue(CLIENT.plainRequest("abay").equals("false"));
		assertTrue(CLIENT.plainRequest("abayı").equals("false"));
		assertTrue(CLIENT.plainRequest("abar").equals("false"));
		assertTrue(CLIENT.plainRequest("abart").equals("false"));
		assertTrue(CLIENT.plainRequest("abartı").equals("true"));
		assertTrue(CLIENT.plainRequest("kalemi").equals("false"));
		assertTrue(CLIENT.plainRequest("atkı").equals("true"));
	}
}
