package br.com.yunikonshine.refugiobrasil.exception;

import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
public class FeignServerInternalServerError extends RuntimeException {

	private static final long serialVersionUID = -1206680018753944519L;

	private static final String message = "Feign server responded with error";

	private final StringBuilder stringBuilder = new StringBuilder();

	public FeignServerInternalServerError(Integer statusCode, String url, String methodKey, Response.Body body)
			throws IOException {
		super(message);
		addMessage("Feign server error with status", statusCode);
		addMessage("Error in URL", url);
		addMessage("Error in Feign methodKey", methodKey);

		try {
			String responseBody = IOUtils.toString(body.asInputStream(), UTF_8.name());
			addMessage("Error body", responseBody);
		} catch (Exception e) {
			log.error("FeignServerInternalServerError: Unable to get Response Body");
		}

		log.error(stringBuilder.toString());
	}

	private void addMessage(String message, Object data) {
		stringBuilder.append(message);
		stringBuilder.append(": ");
		stringBuilder.append(data);
		stringBuilder.append("\n");
	}

}
