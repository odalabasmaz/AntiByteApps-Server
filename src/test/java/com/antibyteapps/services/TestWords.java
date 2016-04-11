package com.antibyteapps.services;

import com.antibyteapps.dictionary.service.DictionaryService;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author Orhun Dalabasmaz
 */
public class TestWords {
	private static DictionaryService DICTIONARY;
	private static ClientService CLIENT;

	private static void initDictionary() {
		if (DICTIONARY == null) {
			DICTIONARY = DictionaryService.getInstance();
		}
	}

	private static void initClientService() {
		if (CLIENT == null) {
			CLIENT = ClientService.getInstance();
		}
	}

	@BeforeClass
	public static void init() {
		initClientService();
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
		assertTrue(CLIENT.isWord("aba"));
		assertFalse(CLIENT.isWord("abaş"));
		assertFalse(CLIENT.isWord("abay"));
		assertFalse(CLIENT.isWord("abayı"));
		assertFalse(CLIENT.isWord("abar"));
		assertFalse(CLIENT.isWord("abart"));
		assertTrue(CLIENT.isWord("abartı"));
		assertFalse(CLIENT.isWord("kalemi"));
		assertTrue(CLIENT.isWord("atkı"));
	}
}
