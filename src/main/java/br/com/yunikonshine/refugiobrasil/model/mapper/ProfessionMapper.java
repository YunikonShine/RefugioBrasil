package br.com.yunikonshine.refugiobrasil.model.mapper;

import br.com.yunikonshine.refugiobrasil.model.domain.Profession;
import br.com.yunikonshine.refugiobrasil.model.request.ProfessionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfessionMapper {

    @Mapping(source = "country", target = "countryId")
    @Mapping(target = "country", ignore = true)
    Profession fromRequest(ProfessionRequest professionRequest);

}
