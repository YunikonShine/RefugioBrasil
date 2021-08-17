package br.com.yunikonshine.refugiobrasil.config;

import feign.Logger.Level;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("br.com.yunikonshine.refugiobrasil")
public class FeignConfig {

    @Bean
    public Level feignLoggerLevel(){
        return Level.FULL;
    }

    @Bean
    public FeignErrorHandler feignErrorHandler() {
        return new FeignErrorHandler();
    }

    @Bean
    public FeignLogHandler feignLogHandler() {
        return new FeignLogHandler();
    }

    @Bean
    public FeignLogConfig feignLogConfig() {
        return new FeignLogConfig();
    }

}
