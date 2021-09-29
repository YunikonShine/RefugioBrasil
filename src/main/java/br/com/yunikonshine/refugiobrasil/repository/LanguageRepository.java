package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.exception.LanguageNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.NonBelongLanguageException;
import br.com.yunikonshine.refugiobrasil.model.domain.Language;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
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

    public void update(Language language) {
        dynamoDBMapper.save(language);
    }

    public void delete(String languageId) throws LanguageNotFoundException {
        Language language = dynamoDBMapper.marshallIntoObject(
                Language.class,
                genericRepository.findById(languageId, Language.TABLE_NAME)
                        .orElseThrow(() -> new LanguageNotFoundException()));

        dynamoDBMapper.delete(language);
    }

    public void save(Language language) {
        dynamoDBMapper.save(language);
    }

    public void validBelongProfessionFromRefugee(String languageId, String refugeeId) throws LanguageNotFoundException, NonBelongLanguageException {
        Map<String, AttributeValue> item = genericRepository.findById(languageId, Language.TABLE_NAME)
                .orElseThrow(() -> new LanguageNotFoundException());

        Language language = dynamoDBMapper.marshallIntoObject(Language.class, item);

        if(!language.getRefugeeId().equals(refugeeId)) {
            throw new NonBelongLanguageException();
        }
    }

}
