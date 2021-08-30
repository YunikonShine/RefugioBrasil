package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.RefugeeNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.domain.Refugee;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RefugeeRepository {

    private final AmazonDynamoDB dynamoDB;

    private final DynamoDBMapper dynamoDBMapper;

    private final CountryRepository countryRepository;

    private final GenericRepository genericRepository;

    public void save(Refugee refugee) {
        dynamoDBMapper.save(refugee.getNecessity());
        dynamoDBMapper.save(refugee.getAddress());

        refugee.getDocuments().forEach(dynamoDBMapper::save);
        refugee.getProfessions().forEach(dynamoDBMapper::save);
        refugee.getLanguages().forEach(dynamoDBMapper::save);
        refugee.getFormations().forEach(dynamoDBMapper::save);
        refugee.getPhones().forEach(dynamoDBMapper::save);

        dynamoDBMapper.save(refugee);
    }

    public List<Refugee> listRefugees() throws CepNotFoundException {
        List<Refugee> refugees = genericRepository.findAll(Refugee.TABLE_NAME).stream()
                .map(i -> dynamoDBMapper.marshallIntoObject(Refugee.class, i))
                .collect(Collectors.toList());

        for (Refugee refugee : refugees) {
            fillCountries(refugee);
        }

        return refugees;
    }

    private void fillCountries(Refugee refugee) throws CepNotFoundException {
        refugee.setOriginCountry(
                countryRepository.findById(refugee.getOriginCountryId()));
        refugee.setBirthCountry(
                countryRepository.findById(refugee.getBirthCountryId()));
    }

    public Refugee findById(String id) throws RefugeeNotFoundException, CepNotFoundException {
        Refugee refugee = dynamoDBMapper.marshallIntoObject(
                Refugee.class,
                genericRepository.findById(id, Refugee.TABLE_NAME)
                        .orElseThrow(() -> new RefugeeNotFoundException()));

        fillCountries(refugee);

        //TODO fill all data

        return refugee;
    }
}