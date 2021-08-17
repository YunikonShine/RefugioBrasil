package br.com.yunikonshine.refugiobrasil.config;

import br.com.yunikonshine.refugiobrasil.utils.LogUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.Response;
import feign.codec.Decoder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Type;
import java.util.Objects;

@Slf4j
public class FeignLogHandler implements Decoder {

    @Autowired
    ObjectMapper objectMapper;

    @SneakyThrows
    @Override
    public Object decode(Response response, Type type) throws FeignException {
        log.info(LogUtils.generateFeignMessageByResponse(response));
        return objectMapper.readValue(response.body().asInputStream(), Class.forName(type.getTypeName()));
    }
}
