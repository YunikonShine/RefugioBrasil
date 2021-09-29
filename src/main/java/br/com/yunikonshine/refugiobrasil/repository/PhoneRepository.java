package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.exception.NonBelongPhoneException;
import br.com.yunikonshine.refugiobrasil.exception.PhoneNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.domain.Phone;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PhoneRepository {

    private final DynamoDBMapper dynamoDBMapper;

    private final GenericRepository genericRepository;

    public List<Phone> getByRefugeeId(String refugeeId) {
        return genericRepository.findByRefugeeId(refugeeId, Phone.TABLE_NAME).stream()
                .map(i -> dynamoDBMapper.marshallIntoObject(Phone.class, i))
                .collect(Collectors.toList());
    }

    public void update(Phone phone) {
        dynamoDBMapper.save(phone);
    }

    public void delete(String phoneId) throws PhoneNotFoundException {
        Phone phone = dynamoDBMapper.marshallIntoObject(
                Phone.class,
                genericRepository.findById(phoneId, Phone.TABLE_NAME)
                        .orElseThrow(() -> new PhoneNotFoundException()));

        dynamoDBMapper.delete(phone);
    }

    public void save(Phone phone) {
        dynamoDBMapper.save(phone);
    }

    public void validBelongPhoneFromRefugee(String phoneId, String refugeeId) throws PhoneNotFoundException, NonBelongPhoneException {
        Map<String, AttributeValue> item = genericRepository.findById(phoneId, Phone.TABLE_NAME)
                .orElseThrow(() -> new PhoneNotFoundException());

        Phone phone = dynamoDBMapper.marshallIntoObject(Phone.class, item);

        if(!phone.getRefugeeId().equals(refugeeId)) {
            throw new PhoneNotFoundException();
        }
    }

}
