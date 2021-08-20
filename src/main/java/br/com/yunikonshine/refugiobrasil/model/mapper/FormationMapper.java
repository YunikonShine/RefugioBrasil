package br.com.yunikonshine.refugiobrasil.model.mapper;

import br.com.yunikonshine.refugiobrasil.model.domain.Formation;
import br.com.yunikonshine.refugiobrasil.model.request.FormationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FormationMapper {

    @Mapping(source = "country", target = "countryId")
    @Mapping(target = "country", ignore = true)
    Formation fromRequest(FormationRequest formationRequest);

}
