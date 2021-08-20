package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.domain.City;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CityRepository {

    private final StateRepository stateRepository;

    private final AmazonDynamoDB dynamoDB;

    private final DynamoDBMapper dynamoDBMapper;

    public City findByName(String name) throws CepNotFoundException {
        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
        expressionAttributeValues.put(":n", new AttributeValue().withS(name));

        Map<String, String> expressionAttributeKeys = new HashMap<>();
        expressionAttributeKeys.put("#n", "name");

        ScanRequest scanRequest = new ScanRequest()
                .withTableName(City.TABLE_NAME)
                .withFilterExpression("#n = :n")
                .withExpressionAttributeValues(expressionAttributeValues)
                .withExpressionAttributeNames(expressionAttributeKeys);

        ScanResult result = dynamoDB.scan(scanRequest);

        Map<String, AttributeValue> item = result.getItems()
                .stream().findFirst()
                .orElseThrow(() -> new CepNotFoundException());

        City city = dynamoDBMapper.marshallIntoObject(City.class, item);
        city.setState(stateRepository.findById(city.getStateId()));

        return city;
    }

    public List<City> findByState(String stateId) {
        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
        expressionAttributeValues.put(":state", new AttributeValue().withN(stateId));

        Map<String, String> expressionAttributeKeys = new HashMap<>();
        expressionAttributeKeys.put("#state", "state_id");

        ScanRequest scanRequest = new ScanRequest()
                .withTableName(City.TABLE_NAME)
                .withFilterExpression("#state = :state")
                .withExpressionAttributeValues(expressionAttributeValues)
                .withExpressionAttributeNames(expressionAttributeKeys);

        ScanResult result = dynamoDB.scan(scanRequest);

        return result.getItems().stream()
                .map(i -> dynamoDBMapper.marshallIntoObject(City.class, i))
                .collect(Collectors.toList());
    }

}
