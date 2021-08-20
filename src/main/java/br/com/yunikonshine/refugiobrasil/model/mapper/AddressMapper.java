package br.com.yunikonshine.refugiobrasil.model.mapper;

import br.com.yunikonshine.refugiobrasil.model.domain.Address;
import br.com.yunikonshine.refugiobrasil.model.request.AddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "city", target = "cityId")
    @Mapping(target = "city", ignore = true)
    Address fromRequest(AddressRequest addressRequest);

}
