package com.antibyteapps.dictionary.service;

import com.antibyteapps.dictionary.common.DictionaryConstants;
import com.antibyteapps.dictionary.dao.WordDB;
import com.antibyteapps.dictionary.domain.WordWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

/**
 * @author Orhun Dalabasmaz
 */
public class DictionaryReader {
	private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryReader.class);
	private final String fileName;

	public DictionaryReader(String fileName) {
		this.fileName = fileName;
	}

	public WordDB read() throws FileNotFoundException {
		final ClassLoader classLoader = getClass().getClassLoader();
		final URL resource = classLoader.getResource("dictionary/" + fileName);
		if (resource == null || resource.getFile() == null) {
			throw new FileNotFoundException("Resource or File is not available.");
		}

		final File file = new File(resource.getFile());
		WordDB wordDB = new WordDB();
		try (Scanner in = new Scanner(file, DictionaryConstants.CHARSET)) {
			String line;
			while (in.hasNext()) {
				line = in.nextLine();
				String[] tokens = line.split("#");
				if (tokens.length != 4) {
					LOGGER.warn("Omitting the word: {}", line);
					continue;
				}
				WordWrapper word = new WordWrapper(tokens[0],
						Boolean.valueOf(tokens[1]),
						Boolean.valueOf(tokens[2]),
						Boolean.valueOf(tokens[3]));
				wordDB.addWord(word);
			}
		}

		return wordDB;
	}

}
