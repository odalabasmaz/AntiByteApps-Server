package com.antibyteapps.dictionary.service;

import com.antibyteapps.dictionary.dao.WordDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Orhun Dalabasmaz
 */
public class DictionaryService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryService.class);
	private static final String FILE_NAME = "words.out";
	private static DictionaryService service;
	private static WordDB DICTIONARY;

	private DictionaryService() {
		initDictionary();
	}

	private void initDictionary() {
		LOGGER.info("Initializing the dictionary...");
		DictionaryReader reader = new DictionaryReader(FILE_NAME);
		try {
			DICTIONARY = reader.read();
			LOGGER.info("Dictionary is ready!");
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Dictionary is NOT ready! {}", e.getMessage());
		}
	}

	public static DictionaryService getInstance() {
		if (service == null) {
			service = new DictionaryService();
		}
		return service;
	}

	public boolean isWord(String word) {
		return DICTIONARY.hasWord(word);
	}

}
