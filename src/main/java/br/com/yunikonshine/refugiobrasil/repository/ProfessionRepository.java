package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.DocumentNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.NonBelongDocumentException;
import br.com.yunikonshine.refugiobrasil.exception.NonBelongProfessionException;
import br.com.yunikonshine.refugiobrasil.exception.ProfessionNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.domain.Document;
import br.com.yunikonshine.refugiobrasil.model.domain.Profession;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProfessionRepository {

    private final DynamoDBMapper dynamoDBMapper;

    private final GenericRepository genericRepository;

    private final CountryRepository countryRepository;

    public List<Profession> getByRefugeeId(String refugeeId) throws CepNotFoundException {
        List<Profession> professions = genericRepository.findByRefugeeId(refugeeId, Profession.TABLE_NAME).stream()
                .map(i -> dynamoDBMapper.marshallIntoObject(Profession.class, i))
                .collect(Collectors.toList());

        for (Profession profession : professions) {
            profession.setCountry(countryRepository.findById(profession.getCountryId()));
        }

        return professions;
    }

    public void update(Profession profession) {
        dynamoDBMapper.save(profession);
    }

    public void delete(String professionId) throws ProfessionNotFoundException {
        Profession profession = dynamoDBMapper.marshallIntoObject(
                Profession.class,
                genericRepository.findById(professionId, Profession.TABLE_NAME)
                        .orElseThrow(() -> new ProfessionNotFoundException()));

        dynamoDBMapper.delete(profession);
    }

    public void save(Profession profession) {
        dynamoDBMapper.save(profession);
    }

    public void validBelongProfessionFromRefugee(String professionId, String refugeeId) throws ProfessionNotFoundException, NonBelongProfessionException {
        Map<String, AttributeValue> item = genericRepository.findById(professionId, Profession.TABLE_NAME)
                .orElseThrow(() -> new ProfessionNotFoundException());

        Profession profession = dynamoDBMapper.marshallIntoObject(Profession.class, item);

        if(!profession.getRefugeeId().equals(refugeeId)) {
            throw new NonBelongProfessionException();
        }
    }
}
