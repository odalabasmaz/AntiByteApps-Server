package com.antibyteapps.services;

import com.antibyteapps.dictionary.common.DictionaryConstants;
import com.antibyteapps.dictionary.service.DictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Orhun Dalabasmaz
 */
@Path("/dictionary")
public class DictionaryWS {
	private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryWS.class);
	private static final DictionaryService DICTIONARY = DictionaryService.getInstance();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getResponse() {
		String response = "You should give me a word to check!";
		return Response
				.status(200)
				.entity(response)
				.encoding(DictionaryConstants.CHARSET)
				.build();
	}

	@GET
	@Path("/{word}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getResponse(@PathParam("word") String word) {
		boolean isWord = DICTIONARY.isWord(word);
		LOGGER.info("Checking for word: \"{}\", isWord: {}", word, isWord);
		String response = word + " is " + (isWord ? "" : "not ") + "a word!";
		return Response
				.status(200)
				.entity(response)
				.encoding(DictionaryConstants.CHARSET)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET")
				.build();
	}

}
