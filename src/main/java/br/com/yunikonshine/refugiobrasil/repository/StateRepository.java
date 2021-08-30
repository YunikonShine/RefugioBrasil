package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.domain.State;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
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

    private final GenericRepository genericRepository;

    public State findById(Long id) throws CepNotFoundException {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("id", id);

        String query = "#id = :id";

        List<Map<String, AttributeValue>> items = genericRepository.getItems(queryMap, query, State.TABLE_NAME);

        Map<String, AttributeValue> item = items.stream().findFirst().orElseThrow(() -> new CepNotFoundException());

        return dynamoDBMapper.marshallIntoObject(State.class, item);
    }

    public List<State> findAll() {
        return genericRepository.findAll(State.TABLE_NAME).stream()
                .map(i -> dynamoDBMapper.marshallIntoObject(State.class, i))
                .collect(Collectors.toList());
    }

}
