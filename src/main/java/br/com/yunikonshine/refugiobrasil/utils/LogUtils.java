package br.com.yunikonshine.refugiobrasil.utils;

import feign.Request;
import feign.Response;

import java.util.Objects;

public class LogUtils {

    public static String generateFeignMessageByRequest(Request request) {
        String body = Objects.nonNull(request.body())
                ? request.body().toString()
                .replaceAll("[\\r\\n]+", " ")
                .replaceAll("[\\s\\s]+", " ")
                : "Empty body";

        String message = String.format("Feign %s request to %s using headers: %s and body: %s",
                request.httpMethod(),
                request.url(),
                request.headers(),
                body);

        return message;
    }

    public static String generateFeignMessageByResponse(Response response) {
        String body = Objects.nonNull(response.body())
                ? response.body().toString()
                    .replaceAll("[\\r\\n]+", " ")
                    .replaceAll("[\\s\\s]+", " ")
                : "Empty body";

        String message = String.format("Feign response from %s with body: %s",
                response.request().url(),
                body);

        return message;
    }

}
