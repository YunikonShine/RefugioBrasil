package br.com.yunikonshine.refugiobrasil.config;

import br.com.yunikonshine.refugiobrasil.config.properties.DefaultProperties;
import br.com.yunikonshine.refugiobrasil.config.properties.LocalStackProperties;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@RequiredArgsConstructor
public class AmazonConfiguration {

    private final LocalStackProperties localStackProperties;

    private final DefaultProperties defaultProperties;

    @Bean
    public ClientConfiguration clientConfiguration() {
        return new ClientConfiguration();
    }

    @Bean
    @Profile("!localstack")
    public AmazonDynamoDB amazonDynamoDB(ClientConfiguration clientConfiguration) {
        return AmazonDynamoDBAsyncClientBuilder.standard()
                .withClientConfiguration(clientConfiguration)
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(
                                        defaultProperties.getAccessKey(),
                                        defaultProperties.getSecretKey())))
                .build();
    }

    @Bean
    @Profile("localstack")
    public AmazonDynamoDB amazonDynamoDBLocalStack(ClientConfiguration clientConfiguration) {
        return AmazonDynamoDBAsyncClientBuilder.standard()
                .withClientConfiguration(clientConfiguration)
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                localStackProperties.getEndpoint(),
                                localStackProperties.getRegion()))
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(
                                        localStackProperties.getAccessKey(),
                                        localStackProperties.getSecretKey())))
                .build();
    }

    @Bean
    public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB) {
        return new DynamoDBMapper(amazonDynamoDB);
    }

    @Bean
    public DynamoDB dynamoDB(AmazonDynamoDB amazonDynamoDB) {
        return new DynamoDB(amazonDynamoDB);
    }

}
