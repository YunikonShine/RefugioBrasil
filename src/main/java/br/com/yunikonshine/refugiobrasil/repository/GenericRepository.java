package br.com.yunikonshine.refugiobrasil.repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class GenericRepository {

    private final AmazonDynamoDB dynamoDB;

    public List<Map<String, AttributeValue>> getItems(Map<String, Object> queryMap, String query, String tableName) {
        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
        Map<String, String> expressionAttributeKeys = new HashMap<>();

        for (String key : queryMap.keySet()) {
            String valueId = ":" + key;
            String keyId = "#" + key;
            expressionAttributeKeys.put(keyId, key);

            Object value = queryMap.get(key);
            String valueString = String.valueOf(value);
            if(value instanceof String) {
                expressionAttributeValues.put(valueId, new AttributeValue().withS(valueString));
            } else if(value instanceof Number) {
                expressionAttributeValues.put(valueId, new AttributeValue().withN(valueString));
            } else if(value instanceof Boolean) {
                expressionAttributeValues.put(valueId, new AttributeValue().withBOOL(Boolean.valueOf(valueString)));
            }
        }

        ScanRequest scanRequest = new ScanRequest()
                .withTableName(tableName)
                .withFilterExpression(query)
                .withExpressionAttributeValues(expressionAttributeValues)
                .withExpressionAttributeNames(expressionAttributeKeys);

        return dynamoDB.scan(scanRequest).getItems();
    }

    public List<Map<String, AttributeValue>> findAll(String tableName) {
        return dynamoDB.scan(new ScanRequest().withTableName(tableName)).getItems();
    }

    public Optional<Map<String, AttributeValue>> findById(Object id, String tableName) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("id", id);

        String query = "#id = :id";

        return getItems(queryMap, query, tableName).stream().findFirst();
    }

    public List<Map<String, AttributeValue>> findByRefugeeId(String refugeeId, String tableName) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("refugee_id", refugeeId);

        String query = "#refugee_id = :refugee_id";

        return getItems(queryMap, query, tableName);
    }

}
