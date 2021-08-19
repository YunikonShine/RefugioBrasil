package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.domain.State;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
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
public class StateRepository {

    private final AmazonDynamoDB dynamoDB;

    private final DynamoDBMapper dynamoDBMapper;

    public State findById(Long id) throws CepNotFoundException {
        Map<String, AttributeValue> expressionAttributeNames = new HashMap<>();
        AttributeValue attributeValue = new AttributeValue();
        attributeValue.setN(String.valueOf(id));
        expressionAttributeNames.put("id", attributeValue);

        GetItemResult itemResult = dynamoDB.getItem(State.TABLE_NAME, expressionAttributeNames);

        if(itemResult.getItem().isEmpty()) {
            throw new CepNotFoundException();
        }

        return dynamoDBMapper.marshallIntoObject(State.class, itemResult.getItem());
    }

    public List<State> findAll() {
        ScanResult scan = dynamoDB.scan(new ScanRequest().withTableName(State.TABLE_NAME));
        List<Map<String, AttributeValue>> attributeValues = scan.getItems();

        return attributeValues.stream()
                .map(i -> dynamoDBMapper.marshallIntoObject(State.class, i))
                .collect(Collectors.toList());
    }

}
