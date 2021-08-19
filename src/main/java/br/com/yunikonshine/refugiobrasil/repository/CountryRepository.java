package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.model.domain.Country;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CountryRepository  {

    private final AmazonDynamoDB dynamo;

    private final DynamoDBMapper dynamoDBMapper;

    public List<Country> findAll() {
        ScanResult scan = dynamo.scan(new ScanRequest().withTableName(Country.TABLE_NAME));
        List<Map<String, AttributeValue>> attributeValues = scan.getItems();

        return attributeValues.stream()
                .map(i -> dynamoDBMapper.marshallIntoObject(Country.class, i))
                .collect(Collectors.toList());

    }

}
