package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.domain.Country;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CountryRepository  {

    private final AmazonDynamoDB dynamoDB;

    private final DynamoDBMapper dynamoDBMapper;

    private final GenericRepository genericRepository;

    public List<Country> findAll() {
        return genericRepository.findAll(Country.TABLE_NAME).stream()
                .map(i -> dynamoDBMapper.marshallIntoObject(Country.class, i))
                .collect(Collectors.toList());
    }

    public Country findById(Long id) throws CepNotFoundException {
        return dynamoDBMapper.marshallIntoObject(
                Country.class,
                genericRepository.findById(id, Country.TABLE_NAME)
                        .orElseThrow(() -> new CepNotFoundException()));
    }

}
