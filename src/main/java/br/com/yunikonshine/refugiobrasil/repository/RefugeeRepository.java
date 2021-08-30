package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.model.domain.Refugee;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RefugeeRepository {

    private final DynamoDBMapper dynamoDBMapper;

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

}
