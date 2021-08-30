package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.model.domain.Profession;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProfessionRepository {

    private final DynamoDBMapper dynamoDBMapper;

    private final GenericRepository genericRepository;

    public List<Profession> getByRefugeeId(String refugeeId) {
        return genericRepository.findByRefugeeId(refugeeId, Profession.TABLE_NAME).stream()
                .map(i -> dynamoDBMapper.marshallIntoObject(Profession.class, i))
                .collect(Collectors.toList());
    }
}
