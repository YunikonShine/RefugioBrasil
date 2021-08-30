package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.model.domain.Phone;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PhonesRepository {

    private final DynamoDBMapper dynamoDBMapper;

    private final GenericRepository genericRepository;

    public List<Phone> getByRefugeeId(String refugeeId) {
        return genericRepository.findByRefugeeId(refugeeId, Phone.TABLE_NAME).stream()
                .map(i -> dynamoDBMapper.marshallIntoObject(Phone.class, i))
                .collect(Collectors.toList());
    }
}
