package br.com.yunikonshine.refugiobrasil.config;

import br.com.yunikonshine.refugiobrasil.config.properties.LocalStackProperties;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@RequiredArgsConstructor
public class AmazonConfiguration {

    private final LocalStackProperties localStackProperties;

    @Bean
    @Profile("!localstack")
    public AmazonS3 s3Client() {
        return AmazonS3ClientBuilder.standard().build();
    }

    @Bean
    @Profile("localstack")
    public AmazonS3 amazonS3LocalStack(final ClientConfiguration clientConfiguration) {
        return AmazonS3Client.builder()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                localStackProperties.getEndpoint(),
                                localStackProperties.getRegion()))
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(
                                        localStackProperties.getAccessKey(),
                                        localStackProperties.getSecretKey())))
                .withPathStyleAccessEnabled(true)
                .build();
    }

    @Bean
    @Profile("!localstack")
    public AmazonDynamoDB amazonDynamoDB(ClientConfiguration clientConfiguration) {
        return AmazonDynamoDBAsyncClientBuilder.standard().withClientConfiguration(clientConfiguration).build();
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

}