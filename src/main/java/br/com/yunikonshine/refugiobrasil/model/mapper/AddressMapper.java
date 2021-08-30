package br.com.yunikonshine.refugiobrasil.model.mapper;

import br.com.yunikonshine.refugiobrasil.model.domain.Address;
import br.com.yunikonshine.refugiobrasil.model.request.AddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class})
public interface AddressMapper {

    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    @Mapping(source = "city", target = "cityId")
    @Mapping(target = "city", ignore = true)
    Address fromRequest(AddressRequest addressRequest);

}
