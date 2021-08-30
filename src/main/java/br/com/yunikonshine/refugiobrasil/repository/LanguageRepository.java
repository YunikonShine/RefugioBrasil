package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.model.domain.Language;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class LanguageRepository {

    private final DynamoDBMapper dynamoDBMapper;

    private final GenericRepository genericRepository;

    public List<Language> getByRefugeeId(String refugeeId) {
        return genericRepository.findByRefugeeId(refugeeId, Language.TABLE_NAME).stream()
                .map(i -> dynamoDBMapper.marshallIntoObject(Language.class, i))
                .collect(Collectors.toList());
    }
}
