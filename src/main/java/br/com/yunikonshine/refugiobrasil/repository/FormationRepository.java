package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.FormationNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.NonBelongFormationException;
import br.com.yunikonshine.refugiobrasil.model.domain.Formation;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class FormationRepository {

    private final DynamoDBMapper dynamoDBMapper;

    private final GenericRepository genericRepository;

    private final CountryRepository countryRepository;

    public List<Formation> getByRefugeeId(String refugeeId) throws CepNotFoundException {
        List<Formation> formations = genericRepository.findByRefugeeId(refugeeId, Formation.TABLE_NAME).stream()
                .map(i -> dynamoDBMapper.marshallIntoObject(Formation.class, i))
                .collect(Collectors.toList());

        for (Formation formation : formations) {
            formation.setCountry(countryRepository.findById(formation.getCountryId()));
        }

        return formations;
    }

    public void update(Formation formation) {
        dynamoDBMapper.save(formation);
    }

    public void delete(String formationId) throws FormationNotFoundException {
        Formation formation = dynamoDBMapper.marshallIntoObject(
                Formation.class,
                genericRepository.findById(formationId, Formation.TABLE_NAME)
                        .orElseThrow(() -> new FormationNotFoundException()));

        dynamoDBMapper.delete(formation);
    }

    public void save(Formation formation) {
        dynamoDBMapper.save(formation);
    }

    public void validBelongFormationFromRefugee(String formationId, String refugeeId) throws FormationNotFoundException, NonBelongFormationException {
        Map<String, AttributeValue> item = genericRepository.findById(formationId, Formation.TABLE_NAME)
                .orElseThrow(() -> new FormationNotFoundException());

        Formation formation = dynamoDBMapper.marshallIntoObject(Formation.class, item);

        if(!formation.getRefugeeId().equals(refugeeId)) {
            throw new NonBelongFormationException();
        }
    }

}
