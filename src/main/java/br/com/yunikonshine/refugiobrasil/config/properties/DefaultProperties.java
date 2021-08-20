package br.com.yunikonshine.refugiobrasil.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("aws")
public class DefaultProperties {

    private String accessKey;

    private String secretKey;

}
