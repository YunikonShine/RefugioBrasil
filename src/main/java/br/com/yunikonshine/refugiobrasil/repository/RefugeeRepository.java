package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.domain.Refugee;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RefugeeRepository {

    private final AmazonDynamoDB dynamoDB;

    private final DynamoDBMapper dynamoDBMapper;

    private final CountryRepository countryRepository;

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
        ScanResult scan = dynamoDB.scan(new ScanRequest().withTableName(Refugee.TABLE_NAME));
        List<Map<String, AttributeValue>> attributeValues = scan.getItems();

        List<Refugee> refugees = attributeValues.stream()
                .map(i -> dynamoDBMapper.marshallIntoObject(Refugee.class, i))
                .collect(Collectors.toList());

        for (Refugee refugee : refugees) {
            fillCountries(refugee);
        }

        return refugees;
    }

    private void fillCountries(Refugee refugee) throws CepNotFoundException {
        refugee.setOriginCountry(
                countryRepository.getById(refugee.getOriginCountryId()));
        refugee.setBirthCountry(
                countryRepository.getById(refugee.getBirthCountryId()));
    }

}
