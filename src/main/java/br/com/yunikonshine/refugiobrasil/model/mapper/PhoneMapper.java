package br.com.yunikonshine.refugiobrasil.model.mapper;

import br.com.yunikonshine.refugiobrasil.model.domain.Phone;
import br.com.yunikonshine.refugiobrasil.model.request.PhoneRefugeeRequest;
import br.com.yunikonshine.refugiobrasil.model.request.PhoneRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class})
public interface PhoneMapper {

    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    Phone fromRequest(PhoneRequest phoneRequest);

    Phone fromRequest(PhoneRequest languageRequest, String id, String refugeeId);

    Phone fromRequest(PhoneRefugeeRequest languageRequest);

}
