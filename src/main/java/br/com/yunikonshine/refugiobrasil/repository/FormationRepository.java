package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.model.domain.Formation;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class FormationRepository {

    private final DynamoDBMapper dynamoDBMapper;

    private final GenericRepository genericRepository;

    public List<Formation> getByRefugeeId(String refugeeId) {
        return genericRepository.findByRefugeeId(refugeeId, Formation.TABLE_NAME).stream()
                .map(i -> dynamoDBMapper.marshallIntoObject(Formation.class, i))
                .collect(Collectors.toList());
    }
}
