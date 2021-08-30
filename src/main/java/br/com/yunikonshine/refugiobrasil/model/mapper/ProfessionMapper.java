package br.com.yunikonshine.refugiobrasil.model.mapper;

import br.com.yunikonshine.refugiobrasil.model.domain.Profession;
import br.com.yunikonshine.refugiobrasil.model.request.ProfessionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class})
public interface ProfessionMapper {

    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    @Mapping(source = "country", target = "countryId")
    @Mapping(target = "country", ignore = true)
    Profession fromRequest(ProfessionRequest professionRequest);

}
