package br.com.yunikonshine.refugiobrasil.model.mapper;

import br.com.yunikonshine.refugiobrasil.model.domain.Formation;
import br.com.yunikonshine.refugiobrasil.model.request.FormationRefugeeRequest;
import br.com.yunikonshine.refugiobrasil.model.request.FormationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class})
public interface FormationMapper {

    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    @Mapping(source = "country", target = "countryId")
    @Mapping(target = "country", ignore = true)
    Formation fromRequest(FormationRequest formationRequest);

    Formation fromRequest(FormationRequest languageRequest, String id, String refugeeId);

    Formation fromRequest(FormationRefugeeRequest languageRequest);

}
