package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.domain.City;
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
public class CityRepository {

    private final StateRepository stateRepository;

    private final GenericRepository genericRepository;

    private final DynamoDBMapper dynamoDBMapper;

    public City findByName(String name) throws CepNotFoundException {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("name", name);

        String query = "#name = :name";

        List<Map<String, AttributeValue>> items = genericRepository.getItems(queryMap, query, City.TABLE_NAME);

        Map<String, AttributeValue> item = items
                .stream().findFirst()
                .orElseThrow(() -> new CepNotFoundException());

        City city = dynamoDBMapper.marshallIntoObject(City.class, item);
        city.setState(stateRepository.findById(city.getStateId()));

        return city;
    }

    public List<City> findByState(Long stateId) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("state_id", stateId);

        String query = "#state_id = :state_id";

        List<Map<String, AttributeValue>> items = genericRepository.getItems(queryMap, query, City.TABLE_NAME);

        return items.stream()
                .map(i -> dynamoDBMapper.marshallIntoObject(City.class, i))
                .collect(Collectors.toList());
    }

}
