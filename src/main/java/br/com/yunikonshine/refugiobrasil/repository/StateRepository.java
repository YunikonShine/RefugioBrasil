package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.domain.State;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class StateRepository {

    private final AmazonDynamoDB dynamoDB;

    private final DynamoDBMapper dynamoDBMapper;

    private final GenericRepository genericRepository;

    public State findById(Long id) throws CepNotFoundException {
        return dynamoDBMapper.marshallIntoObject(
                State.class,
                genericRepository.findById(id, State.TABLE_NAME)
                        .orElseThrow(() -> new CepNotFoundException()));
    }

    public List<State> findAll() {
        return genericRepository.findAll(State.TABLE_NAME).stream()
                .map(i -> dynamoDBMapper.marshallIntoObject(State.class, i))
                .collect(Collectors.toList());
    }

}
