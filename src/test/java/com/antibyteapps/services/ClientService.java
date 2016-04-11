package com.antibyteapps.services;

import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * @author Orhun Dalabasmaz
 */
public class ClientService {
	private static final String ENDPOINT_LOCAL = "http://localhost:8080";
	private static final String ENDPOINT_REMOTE = "http://antibyteapps.orhundalabasmaz.com";
	private static final String ENDPOINT = ENDPOINT_REMOTE;
	private static final String SERVICES = "services";
	private static final String SERVICE_PATH = "dictionary";

	private static ClientService service;
	private static WebTarget target;

	private ClientService() {
		initService();
	}

	public static ClientService getInstance() {
		if (service == null) {
			service = new ClientService();
		}
		return service;
	}

	private void initService() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		target = client.target(getBaseURI());
	}

	public void test() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI());

		String response = target
				.path(SERVICES)
				.path(SERVICE_PATH)
				.request()
				.accept(MediaType.TEXT_PLAIN)
				.get(Response.class)
				.toString();

		String plainAnswer = target.path(SERVICES).path(SERVICE_PATH).request().accept(MediaType.TEXT_PLAIN).get(String.class);
		String xmlAnswer = target.path(SERVICES).path(SERVICE_PATH).request().accept(MediaType.TEXT_XML).get(String.class);
		String htmlAnswer = target.path(SERVICES).path(SERVICE_PATH).request().accept(MediaType.TEXT_HTML).get(String.class);

		System.out.println(response);
		System.out.println(plainAnswer);
		System.out.println(xmlAnswer);
		System.out.println(htmlAnswer);
	}

	private URI getBaseURI() {
		return UriBuilder.fromUri(ENDPOINT).build();
	}

	private String plainRequest() {
		return target.path(SERVICES).path(SERVICE_PATH).request().accept(MediaType.TEXT_PLAIN).get(String.class);
	}

	private String plainRequest(String param) {
		return target.path(SERVICES).path(SERVICE_PATH).path(param).request().accept(MediaType.TEXT_PLAIN).get(String.class);
	}

	public boolean isWord(String word) {
		return "true".equals(plainRequest(word));
	}
}
