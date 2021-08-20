package br.com.yunikonshine.refugiobrasil.model.mapper;

import br.com.yunikonshine.refugiobrasil.model.domain.Refugee;
import br.com.yunikonshine.refugiobrasil.model.request.RefugeeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, FormationMapper.class, ProfessionMapper.class})
public interface RefugeeMapper {

    @Mapping(source = "birthCountry", target = "birthCountryId")
    @Mapping(target = "birthCountry", ignore = true)
    @Mapping(source = "originCountry", target = "originCountryId")
    @Mapping(target = "originCountry", ignore = true)
    Refugee fromRequest(RefugeeRequest refugeeRequest);

}
