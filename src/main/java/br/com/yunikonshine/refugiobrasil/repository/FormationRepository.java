package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
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
}
