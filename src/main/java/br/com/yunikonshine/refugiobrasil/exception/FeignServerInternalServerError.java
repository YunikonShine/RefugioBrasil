package br.com.yunikonshine.refugiobrasil.exception;

import br.com.yunikonshine.refugiobrasil.utils.LogUtils;
import feign.Response;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class FeignServerInternalServerError extends RuntimeException {

	private static final String message = "Feign server responded with error";

	public FeignServerInternalServerError(Integer statusCode, String url, String methodKey, Response.Body body)
			throws IOException {
		super(message);
		log.error(LogUtils.generateFeignMessageByBodyAndData(statusCode, url, methodKey, body));
	}

}
