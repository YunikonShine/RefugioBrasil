package br.com.yunikonshine.refugiobrasil.utils;

import feign.Request;
import feign.Response;

import java.util.Objects;

public class LogUtils {

    public static String generateFeignMessageByBodyAndData(Integer statusCode, String url, String methodKey, Response.Body bodyToConvert) {
        String body = Objects.nonNull(bodyToConvert)
                ? bodyToConvert.toString()
                .replaceAll("[\\r\\n]+", " ")
                .replaceAll("[\\s\\s]+", " ")
                : "Empty body";

        String message = String.format("Feign has an error in %s with key %s error status code %s and body: %s",
                url,
                methodKey,
                statusCode,
                body);

        return message;
    }

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
