package br.com.yunikonshine.refugiobrasil.config;

import br.com.yunikonshine.refugiobrasil.exception.FeignServerInternalServerError;
import feign.Response;
import feign.codec.ErrorDecoder;
import feign.template.UriUtils;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;

import java.nio.charset.StandardCharsets;

public class FeignErrorHandler implements ErrorDecoder {

    @SneakyThrows
    @Override
    public Exception decode(String methodKey, Response response) {
        if (HttpStatus.resolve(response.status()).is2xxSuccessful()) {
            return this.decode(methodKey, response);
        }
        return new FeignServerInternalServerError(
                response.status(),
                UriUtils.decode(response.request().url(), StandardCharsets.UTF_8),
                methodKey,
                response.body());
    }

}
