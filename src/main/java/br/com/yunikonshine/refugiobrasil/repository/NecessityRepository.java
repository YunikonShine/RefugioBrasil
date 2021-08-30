package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.domain.Necessity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class NecessityRepository {

    private final DynamoDBMapper dynamoDBMapper;

    private final GenericRepository genericRepository;

    public Necessity findById(Long id) throws CepNotFoundException {
        return dynamoDBMapper.marshallIntoObject(
                Necessity.class,
                genericRepository.findById(id, Necessity.TABLE_NAME)
                        .orElseThrow(() -> new CepNotFoundException()));
    }

}
