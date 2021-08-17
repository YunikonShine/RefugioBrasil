package br.com.yunikonshine.refugiobrasil.config;

import br.com.yunikonshine.refugiobrasil.utils.LogUtils;
import feign.Logger;
import feign.Request;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class FeignLogConfig extends Logger {

    protected String format(String configKey, String format, Object... args) {
        return String.format(methodTag(configKey) + format, args);
    }

    @Override
    protected void log(String configKey, String format, Object... args) {
        log.debug(format(configKey, format, args));
    }

    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {
        super.logRequest(configKey, logLevel, request);
        log.info(LogUtils.generateFeignMessageByRequest(request));
    }

}
