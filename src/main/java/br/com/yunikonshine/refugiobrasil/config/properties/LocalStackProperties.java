package br.com.yunikonshine.refugiobrasil.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("localstack")
public class LocalStackProperties {

    private String endpoint;

    private String region;

    private String accessKey;

    private String secretKey;

}
