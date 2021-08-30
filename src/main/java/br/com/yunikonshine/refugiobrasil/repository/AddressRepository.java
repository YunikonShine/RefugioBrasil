package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.exception.AddressNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.domain.Address;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AddressRepository {

    private final DynamoDBMapper dynamoDBMapper;

    private final GenericRepository genericRepository;

    private final CityRepository cityRepository;

    public Address findById(String id) throws AddressNotFoundException, CepNotFoundException {
        Address address = dynamoDBMapper.marshallIntoObject(
                Address.class,
                genericRepository.findById(id, Address.TABLE_NAME)
                        .orElseThrow(() -> new AddressNotFoundException()));

        address.setCity(cityRepository.findById(address.getCityId()));

        return address;
    }

}
